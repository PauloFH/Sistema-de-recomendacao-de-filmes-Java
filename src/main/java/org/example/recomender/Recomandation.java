package org.example.recomender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import java.io.File;
import java.io.IOException;
public class Recomandation {
        public DataModel getModelfilmes () throws IOException{
            return getModel ("filmes.csv");
        }
        private DataModel getModel(String data) throws IOException{
            File file = new File ("src/main/resources/"+ data);
            return new FileDataModel(file);
        }

}
