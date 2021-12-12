package by.busir.yanushkevich.lab03.server.dao.writer;

public class XMLWriterException extends Exception{
    public XMLWriterException() {
    }

    public XMLWriterException(String message) {
        super(message);
    }

    public XMLWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLWriterException(Throwable cause) {
        super(cause);
    }
}
