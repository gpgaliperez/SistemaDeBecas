package com.modeladosemanticos.sistemadebecas.controller;
import com.modeladosemanticos.sistemadebecas.domain.Alumno;
import com.modeladosemanticos.sistemadebecas.utils.QueryUtil;
import com.modeladosemanticos.sistemadebecas.utils.UpdateUtil;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.impl.SimpleBinding;



public class OntologiasController {


    private RepositoryConnection connection;

   public OntologiasController(RepositoryConnection connection) {
        this.connection = connection;
    }

    public void guardarData(Alumno alumno) {

        connection.begin();

        try {
            Integer idAlumno = alumno.getId();
            Integer idBeca = alumno.getBeca().getId();
            Integer cantidadHermanos = alumno.getBeca().getCantidadHermanos();
            Double diferenciaIngresosGastos = alumno.getBeca().getDiferenciaIngresosGastos();

            guardarAlumno(idAlumno);
            guardarBeca(idBeca, cantidadHermanos, diferenciaIngresosGastos);
            insertarBecaAlumno(idAlumno, idBeca);

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private void guardarAlumno(Integer id) {
        IRI alumnoURI = uriAlumno(id);

        UpdateUtil.executeUpdate(connection,
                String.format(
                        "PREFIX db: <http://www.semanticweb.org/palov/ontologies/2021/6/untitled-ontology-6#>" +
                                "INSERT DATA {" +
                                "<%s> db:idPostulante " + id +
                                "<%s> rdf:type db:Postulante " +
                                "}", alumnoURI, alumnoURI
                ));
    }

    private void guardarBeca(Integer id, Integer count, Double income) {

        IRI becaURI = uriBeca(id);

        UpdateUtil.executeUpdate(connection,
                String.format(
                        "PREFIX db: <http://www.semanticweb.org/palov/ontologies/2021/6/untitled-ontology-6#>" +
                                "INSERT DATA {" +
                                "<%s> db:idSolicitud " + id + "." +
                                "<%s> db:cantidadHermanos " + count + "." +
                                "<%s> db:ingresosNetos " + "\"" + income + "\""+ "^^xsd:double" +"." +
                                "<%s> rdf:type db:Solicitud " +
                                "}", becaURI, becaURI, becaURI, becaURI
                ));
    }

    private void insertarBecaAlumno(Integer idStudent, Integer idScholarship) {

        IRI alumnoURI = uriAlumno(idStudent);
        IRI becaURI = uriAlumno(idScholarship);

        UpdateUtil.executeUpdate(connection,
                String.format(
                        "PREFIX db: <http://www.semanticweb.org/palov/ontologies/2021/6/untitled-ontology-6#>" +
                                "INSERT DATA {" +
                                "<%s> db:presentoSolicitud <%s>" +
                                "}", alumnoURI, becaURI
                ));
    }

    public void listScholarshipForStudent(Integer idStudent) {

        TupleQueryResult result = QueryUtil.evaluateSelectQuery(connection,
                "PREFIX onto: <http://www.semanticweb.org/palov/ontologies/2021/6/untitled-ontology-6#>" +
                        "SELECT ?solicitud WHERE {" +
                        "?solicitud a onto:Solicitud ." +
                        "}",
                new SimpleBinding("p1", uriAlumno(idStudent))
        );

        while (result.hasNext()) {
            BindingSet bindingSet = result.next();
            IRI s1 = (IRI) bindingSet.getBinding("s1").getValue();

            System.out.println("RESULTADO " + s1.getLocalName());
        }

        result.close();
    }

    private IRI uriAlumno(Integer id) {
        return SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/lenovo/ontologies/2021/5/Semantica#Postulante" + id);
    }

    private IRI uriBeca(Integer id) {
        return SimpleValueFactory.getInstance().createIRI("http://www.semanticweb.org/lenovo/ontologies/2021/6/Semantica#Solicitud" + id);
    }
}
