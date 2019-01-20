package creational.factory.logger;

public class FileLogger implements Logger {

    @Override
    public void log(String msg) {
        FileUtil futil = new FileUtil();
        futil.writeToFile("log.txt", msg, true);
    }
}
