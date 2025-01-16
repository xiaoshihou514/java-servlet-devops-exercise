package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PdfResultPage implements Page {
    private final String query;
    private final String answer;

    public PdfResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        File tempFile = File.createTempFile("simplewebapp", ".md");
        PrintWriter writer = new PrintWriter(tempFile);

        if (answer == null || answer.isEmpty()) {
            writer.println("No results found");
        } else {
            writer.printf("# Search results: %s\n", query);
            writer.println(answer);
        }
        writer.close();

        String path = tempFile.getAbsolutePath();
        String pdfPath = path + ".pdf";

        ProcessBuilder pb = new ProcessBuilder("pandoc", path, "-o", pdfPath);
        pb.environment().put("PWD", tempFile.getParent());
        try {
            Process process = pb.start();
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Disposition", "inline;filename=\"response.pdf\"");

        OutputStream out = resp.getOutputStream();
        InputStream inputStream = new FileInputStream(pdfPath);
        out.write(inputStream.readAllBytes());
        out.close();
    }
}
