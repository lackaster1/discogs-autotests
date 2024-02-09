package utils.steps;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class BaseSteps {

    public <T> Response<T> execute(Call<T> call) {
        try {
            return call.execute();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
