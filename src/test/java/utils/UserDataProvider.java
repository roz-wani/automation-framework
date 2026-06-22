package utils;

import model.User;
import org.testng.annotations.DataProvider;

import java.util.List;

public class UserDataProvider {

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws Exception {

        List<User> users = JsonUtil.readJsonList(
                "src/test/resources/user.json",
                User.class);

        Object[][] data = new Object[users.size()][1];

        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }

        return data;
    }
}
