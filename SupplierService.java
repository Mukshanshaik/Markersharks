package markersharkassessementservice;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> querySuppliers(String location, String natureOfBusiness, String manufacturingProcesses, Pageable pageable) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(location, natureOfBusiness, manufacturingProcesses, pageable);
  
    }

}
