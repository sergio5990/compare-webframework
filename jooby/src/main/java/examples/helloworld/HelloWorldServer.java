package examples.helloworld;


import static io.jooby.Jooby.runApp;

public class HelloWorldServer {

    public static void main(final String[] args) throws InterruptedException {
        Thread.sleep(10_000);
        runApp(args, app -> {
            app.get("/hello", ctx -> "Hello World");
        });
    }
}
