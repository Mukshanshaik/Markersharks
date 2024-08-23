package markersharksassessementrepositary;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
    @Query("SELECT s FROM Supplier s WHERE "
           + "(:location IS NULL OR s.location = :location) AND "
           + "(:natureOfBusiness IS NULL OR s.natureOfBusiness = :natureOfBusiness) AND "
           + "(:manufacturingProcesses IS NULL OR s.manufacturingProcesses IN :manufacturingProcesses)")
    Page<Supplier> findByCriteria(@Param("location") String location, 
                                  @Param("natureOfBusiness") String natureOfBusiness, 
                                  @Param("manufacturingProcesses") List<String> manufacturingProcesses, 
                                  Pageable pageable);


}
