package gSon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenerarGson {
    private static final String FILE_NAME = "listaPersonas.json";
    
    private Gson gson;

    public GenerarGson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void generarJson(ListaPersonas lista) {
        String json = gson.toJson(lista);
        System.out.println(json);
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListaPersonas getListaDesdeJson() {
        ListaPersonas ret = null;
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                String json = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
                ret = gson.fromJson(json, ListaPersonas.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ret == null) {
            ret = new ListaPersonas();
        }
        return ret;
    }
    
}
