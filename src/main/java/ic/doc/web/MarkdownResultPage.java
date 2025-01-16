package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MarkdownResultPage implements Page {
    private final String query;
    private final String answer;

    public MarkdownResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.setHeader("Content-Disposition", "as-attachment;filename=\"response.md\"");
        PrintWriter writer = resp.getWriter();

        if (answer == null || answer.isEmpty()) {
            writer.println("No results found");
        } else {
            writer.printf("# Search results: %s\n", query);
            writer.println(answer);
        }
    }
}
