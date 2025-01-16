package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        StringBuilder results = new StringBuilder();
        if (query.toLowerCase().contains("shakespeare")) {
            results.append("William Shakespeare (26 April 1564 - 23 April 1616) was an\n" + "English poet, playwright, and actor, widely regarded as the greatest\n" + "writer in the English language and the world's pre-eminent dramatist. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("asimov")) {
            results.append("Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" + "American writer and professor of Biochemistry, famous for\n" + "his works of hard science fiction and popular science. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("ayase eli")) {
            results.append("Eli is Otonokizaka Academy's third-year student council president who is determined to save the school. Although she opposes Honoka's plan at first, she ends up becoming the second-to-last girl to join _'s. She is part Russian because of her grandma, and tends to say the Russian word \"______\" (pronounced horosho, \"good\"). She is very talented, excelling at academics and athleticion, and is able to perform her duties as the student council president flawlessly. Eli's specialty is quilting. Her experience with ballet ultimately qualifies her as the group's choreographer.");
            results.append(System.lineSeparator());
        }

        return results.toString();
    }
}
