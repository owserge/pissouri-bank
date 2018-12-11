package com.pissouri;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Static utility methods for managing resources
 */
final class Resources {

    /**
     * @return The contents of a class path resource file, by file name
     */
    static String getResourceAsString(String fileName, Class<?> callerClass) {

        try (InputStream stream = getResourceAsStream(fileName, callerClass)) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\A");
            return scanner.next();

        } catch (NoSuchElementException e) {
            return null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return An input stream for a class path resource file, by file name
     * @throws IOException If the resource could not be found
     */
    static InputStream getResourceAsStream(String fileName, Class<?> callerClass) throws IOException {

        InputStream stream = callerClass.getResourceAsStream(fileName);
        if (stream == null) {
            String packageName = callerClass.getPackage().getName();
            throw new IOException(String.format("File %s not found in package %s", fileName, packageName));
        }

        return stream;
    }
}
