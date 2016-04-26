package org.teiid.example;

import static org.teiid.example.JDBCUtils.execute;
import static org.teiid.example.JDBCUtils.close;

import java.sql.Connection;

import org.teiid.resource.adapter.ws.WSManagedConnectionFactory;
import org.teiid.runtime.EmbeddedConfiguration;
import org.teiid.runtime.EmbeddedServer;
import org.teiid.translator.swagger.SwaggerExecutionFactory;

public class TeiidEmbeddedSwaggerPetstore {
    
    static String[] getCalls = new String[]{"EXEC getPetById('1')",
                                            "EXEC getInventory()",
                                            "EXEC getOrderById('11')",
                                            "EXEC getUserByName('user1')"};
    
    public static void main(String[] args) throws Exception {

        EmbeddedServer server = new EmbeddedServer();
        
        SwaggerExecutionFactory factory = new SwaggerExecutionFactory();
        factory.start();
        server.addTranslator("translator-rest", factory);
        
        WSManagedConnectionFactory managedconnectionFactory = new WSManagedConnectionFactory();
        managedconnectionFactory.setEndPoint("http://petstore.swagger.io/v2");
        server.addConnectionFactory("java:/PetStoreRESTWebSvcSource", managedconnectionFactory.createConnectionFactory());

        server.start(new EmbeddedConfiguration());
        
        server.deployVDB(TeiidEmbeddedSwaggerPetstore.class.getClassLoader().getResourceAsStream("swagger-petstore-vdb.xml"));
        
        Connection conn = server.getDriver().connect("jdbc:teiid:restwebservice", null);
        
        for(String call : getCalls){
            execute(conn, call, false);
        }
        
        close(conn);
        server.stop();
    }

}
