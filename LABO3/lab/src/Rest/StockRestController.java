package Rest;

import dao.StockDao;
import dao.StoreDao;
import Model.Stock;
import Model.Store;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StockRestController {
    private final StockDao stockDao;
    private final StoreDao storeDao;

    public StockRestController() {
        try {
            String host = System.getenv().getOrDefault("DB_HOST", "localhost");
            String databaseUrl = "jdbc:postgresql://" + host + ":5432/magasin";
            String user = "magasin_user";
            String password = "magasinpswd";
            com.j256.ormlite.support.ConnectionSource cs = new com.j256.ormlite.jdbc.JdbcConnectionSource(databaseUrl, user, password);
            this.stockDao = new StockDao(cs);
            this.storeDao = new StoreDao(cs);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur d'initialisation de la connexion à la base", e);
        }
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<List<Stock>> getStockByStore(@PathVariable int id) {
        try {
            Store store = storeDao.findById(id);
            if (store == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            List<Stock> stocks = stockDao.listByStore(store);
            return ResponseEntity.ok(stocks);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
} 