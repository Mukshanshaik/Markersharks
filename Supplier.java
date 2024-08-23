package markersharksassessement;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public static void main(String[] args) {

    private Long supplierId;
    
    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness;
    
    @ElementCollection
    private List<String> manufacturingProcesses;
    
}


	

}
