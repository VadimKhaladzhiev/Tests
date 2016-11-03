package tests.jdbc_test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcTest {
    public static void main(String[] args) {
        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:oracle:thin:@10.5.1.20:1521:tbm06000";
        //Имя пользователя БД
        String name = "web_whs";
        //Пароль
        String password = "ias_admin1";
        try {
            //Загружаем драйвер
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("Соединение установлено");
            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            Statement statement = null;

            statement = connection.createStatement();
            //Выполним запрос
            ResultSet result1 = statement.executeQuery(
                    "select * from web2.GRAPH_CONFIG");
            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать
            //метод next() , с помощью которого переходим к следующему элементу
            System.out.println("Выводим statement");
            while (result1.next()) {
                System.out.println("Номер в выборке #" + result1.getRow()
                        + "\t" + result1.getLong("kod")
                        + "\t" + result1.getString("id"));
            }

//            PreparedStatement preparedStatement = connection.prepareStatement();
//            preparedStatement.setInt(1, 11);
//            preparedStatement.setString(2, "mkyong");
//            preparedStatement.setString(3, "system");
//            preparedStatement .executeUpdate();

//            CallableStatement callableStatement = connection.prepareCall();
//            callableStatement.setAsciiStream();

        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(JdbcTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
