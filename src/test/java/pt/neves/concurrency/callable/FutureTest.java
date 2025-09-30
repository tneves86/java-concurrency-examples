package pt.neves.concurrency.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FutureTest {

    @Test
    public void simpleTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Boolean> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return true;
        });

        try {
            assertTrue(future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
