package com.lacerdev.statistics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Reads the whole of standard input until an End-of-File character (EOF) is found.
 * An EOF can be entered in the terminal with the shortcut `ctrl + d` (Linux) or `ctrl + z` (Windows).
 */
public class SystemInputBufferedReader {
    // Internal reader
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Reads the whole of standard input until an End-of-File character (EOF) is found.
     * <p>
     * An EOF can be entered in the terminal with the shortcut `ctrl + d` (Linux) or `ctrl + z` (Windows).
     * @return A string containing the content that was read, including newlines for each line.
     */
    public String readUntilEOF() {
        StringBuilder result = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result.append(line).append('\n');
            }
        } catch (IOException e) {
            System.err.println("Failed to read input");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Failed to close file");
            }
        }

        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    /**
     * {@link BufferedReader#close()}
     */
    void close() throws IOException {
        reader.close();
    }

    /**
     * {@link BufferedReader#lines()}
     */
    Stream<String> lines() {
        return reader.lines();
    }

    /**
     * {@link java.io.BufferedReader#mark(int)}
     */
    void mark(int readAheadLimit) throws IOException {
        reader.mark(readAheadLimit);
    }

    /**
     * {@link BufferedReader#markSupported()}
     */
    boolean markSupported() {
        return reader.markSupported();
    }

    /**
     * {@link BufferedReader#read()}
     */
    int read() throws IOException {
        return reader.read();
    }

    /**
     * {@link java.io.BufferedReader#read(char[], int, int)}
     */
    int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    /**
     * {@link BufferedReader#readLine()}
     */
    String readLine() throws IOException {
        return reader.readLine();
    }

    /**
     * {@link BufferedReader#ready()}
     */
    boolean ready() throws IOException {
        return reader.ready();
    }

    /**
     * {@link BufferedReader#reset()}
     */
    void reset() throws IOException {
        reader.reset();
    }

    /**
     * {@link java.io.BufferedReader#skip(long)}
     */
    long skip(long n) throws IOException {
        return reader.skip(n);
    }
}