package exercise02.application;

import exercise02.entitites.Comment;
import exercise02.entitites.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("WOW that's awesome!");
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand", "Im going to visit his wonderful country!", 12);
        p1.addComments(c1);
        p1.addComments(c2);

        System.out.println(p1);

        Comment c3 = new Comment("Good Night");
        Comment c4 = new Comment("may the force be with you");
        Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomorrow", 5);
        p2.addComments(c3);
        p2.addComments(c4);

        System.out.println(p2);

    }
}
