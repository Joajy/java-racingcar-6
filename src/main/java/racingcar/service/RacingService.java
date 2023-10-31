package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.validator.RacingValidator.checkAllCarNameException;
import static racingcar.validator.RacingValidator.checkAllTryCountException;
import static racingcar.view.InputView.getCarNameNotification;
import static racingcar.view.InputView.getNumberOfTry;
import static racingcar.view.OutputView.printResult;
import static racingcar.view.OutputView.printWinnerList;

public class RacingService {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_MOVE_CONDITION = 4;

    public static void doRacing(){
        List<Car> carList = new ArrayList<>();
        getCarInput(carList);
        int tryCount = getTryCount();
        for (int i = 0; i < tryCount; ++i) {
            moveOrNot(carList);
            printResult(carList);
        }
        printWinnerList(carList);
    }

    public static int getTryCount() {
        getNumberOfTry();
        String tryCount = readLine();
        checkAllTryCountException(tryCount);
        return Integer.parseInt(tryCount);
    }

    public static void getCarInput(List<Car> carList){
        String carName = getCarName();
        splitCarList(carList, carName);
        checkAllCarNameException(carList);
    }

    public static String getCarName() {
        getCarNameNotification();
        return readLine();
    }

    public static void splitCarList(List<Car> carList, String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public static void moveOrNot(List<Car> carList) {
        for (Car car : carList) {
            determineRandomNumber(car);
        }
    }

    public static void determineRandomNumber(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= MINIMUM_MOVE_CONDITION) {
            car.move();
        }
    }
}
