
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product, Integer> {

    private String serverUrl;
    private String user;
    private String password;

    public ProductDAO(String serverUrl, String user, String password) {
        super();
        this.serverUrl = serverUrl;
        this.user = user;
        this.password = password;
        init();
    }

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(this.serverUrl + "/ProductManagement", this.user, this.password);
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }

    public void init() {
        try {
            Connection conn = DriverManager.getConnection(this.serverUrl, this.user, this.password);
            createDatabaseIfNotExist(conn);
            createProductTableIfNotExist(conn);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabaseIfNotExist(Connection conn) {
        try {
            String sql1 = "CREATE DATABASE IF NOT EXISTS ProductManagement";
            PreparedStatement ptm1 = conn.prepareStatement(sql1);
            String sql2 = "use ProductManagement";
            PreparedStatement ptm2 = conn.prepareStatement(sql2);

            ptm1.executeUpdate();
            ptm2.execute();

            ptm1.close();
            ptm2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createProductTableIfNotExist(Connection conn) {
        try {
            String sql1 = "DROP TABLE IF EXISTS Product";
            PreparedStatement ptm1 = conn.prepareStatement(sql1);
            ptm1.executeUpdate();
            ptm1.close();

            String sql2 = "CREATE TABLE Product(id SERIAL PRIMARY KEY, name VARCHAR(200), price INT)";
            PreparedStatement ptm2 = conn.prepareStatement(sql2);
            ptm2.executeUpdate();
            ptm2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Integer add(Product item) {
        Integer id = null;
        String sql = "INSERT INTO Product (name, price) values (?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,item.getName());
            statement.setInt(2, item.getPrice());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            conn.commit();

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Product> readAll() {
        List<Product> results = new ArrayList<>();
        String sql = "SELECT * FROM product";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                results.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public Product read(Integer id) {
        Product result = null;
        String sql = "SELECT * FROM product WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, (Integer) id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Product();
                result.setId(resultSet.getInt("id"));
                result.setName(resultSet.getString("name"));
                result.setPrice(resultSet.getInt("price"));
            } else {
                return null;
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean update(Product item) {
        String sql = "UPDATE Product SET name = ?, price = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            statement.setNString(1, (String) item.getName());
            statement.setInt(2, (Integer) item.getPrice());
            statement.setInt(3, (Integer) item.getId());
            int rows = statement.executeUpdate();
            conn.commit();

            if (rows == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) id);
            int rows = statement.executeUpdate();
            connection.commit();

            if (rows == 1) {
                return true;
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

}
