package Mail;

/**
 * Created by bse71 on 15.02.2017.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
    private static final String ZIP_FILENAME = "logs";
    public static String toZip(String pathFile, int bufLen) {
        byte[] buffer = new byte[bufLen];
        final String zipFile = new String(ZIP_FILENAME + ".zip");

        try{
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry("applog.txt");
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(pathFile);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            //remember close it
            zos.close();

            System.out.println("Done");

        }catch(IOException ex){
            ex.printStackTrace();
        }
        return zipFile;
    }
}
