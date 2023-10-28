package racingcar.validator;

import racingcar.entity.Car;

import java.util.List;

public class CarValidator {

    private static final int CHECK_IF_TRY_COUNT_LESS_THAN_ZERO = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String STRING_REGEX = "^[\\w]*$";

    public static void checkAllException(List<Car> carList){
        for(Car carName : carList){
            checkCarNameLength(carName.getCarName());
            checkCarNameType(carName.getCarName());
        }
    }

    public static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameType(String carName) {
        if (!carName.matches(STRING_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkTryCount(int tryCount) {
        if (tryCount < CHECK_IF_TRY_COUNT_LESS_THAN_ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
