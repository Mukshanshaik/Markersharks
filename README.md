@Entity: This annotation specifies that this class is an entity (i.e., a table in the database).
@Table(name = "suppliers"): This annotation specifies the name of the table in the database. If not specified, the table name would default to the class name.
@Id: Marks the supplierId field as the primary key of the entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): This annotation is used to automatically generate the primary key value. The IDENTITY strategy means that the database will generate a unique value for this column.
Fields: The other fields (companyName, website, location, natureOfBusiness, manufacturingProcesses) represent the attributes of each supplier. These fields correspond to columns in the suppliers table.
JpaRepository<Supplier, Long>: This interface extends JpaRepository, which provides standard CRUD (Create, Read, Update, Delete) operations. The Supplier is the entity type, and Long is the type of the primary key.
Custom Query Method: findByLocationAndNatureOfBusinessAndManufacturingProcesses is a custom query method. Spring Data JPA automatically generates the SQL based on the method name. It filters suppliers by location, natureOfBusiness, and manufacturingProcesses.
Pageable: The method accepts a Pageable parameter, which allows for pagination of results. It returns a Page<Supplier>, which contains the suppliers and pagination information.
@Service: Indicates that this class is a service component in the Spring framework. It encapsulates business logic and interacts with the repository layer.
@Autowired: Automatically injects the SupplierRepository instance into the SupplierService.
querySuppliers Method: This method calls the findByLocationAndNatureOfBusinessAndManufacturingProcesses method of the repository, passing in the filter criteria and pagination details. It returns a paginated list of suppliers.@RestController: Indicates that this class is a REST controller, meaning it handles HTTP requests and returns data as JSON (by default).
@RequestMapping("/api/supplier"): Sets the base URL path for all endpoints in this controller.
@Autowired: Injects the SupplierService instance into the controller.
@PostMapping("/query"): Maps HTTP POST requests sent to /api/supplier/query to this method.
@RequestParam: Maps HTTP request parameters to method parameters. This allows the client to pass in the search criteria (location, natureOfBusiness, manufacturingProcesses) and pagination information (page, size).
Pageable pageable = PageRequest.of(page, size): Creates a Pageable object that encapsulates the pagination information.
ResponseEntity.ok(suppliers): Returns an HTTP 200 OK response with the list of suppliers in the response body.@ControllerAdvice: Indicates that this class provides centralized exception handling for all controllers.
@ExceptionHandler(MethodArgumentNotValidException.class): This method handles exceptions of type MethodArgumentNotValidException, which occurs when validation fails for method arguments.
ResponseEntity<String> handleValidationExceptions: This method returns an HTTP 400 Bad Request response with a message extracted from the validation error.
Summary
The Supplier entity represents the supplier data stored in the database.
The SupplierRepository provides methods to interact with the database, including a custom method to find suppliers based on specific criteria.
The SupplierService encapsulates business logic and interacts with the repository.
The SupplierController exposes the API endpoint to query suppliers based on location, nature of business, and manufacturing processes, with support for pagination.
The GlobalExceptionHandler is used for centralized error handling, improving the API's robustness and user-friendliness.
