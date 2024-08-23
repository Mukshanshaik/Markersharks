package markersharkassessementcontroller;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
        @RequestBody SupplierQueryDTO queryDTO,
        Pageable pageable) {
        
        Page<Supplier> suppliers = supplierService.querySuppliers(queryDTO, pageable);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }


}
