package org.clinikraj.model;// default package
// Generated Oct 18, 2013 1:22:29 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PatientTestSubGroups generated by hbm2java
 */
@Entity
@Table(name="patient_test_sub_groups"
    
)
public class PatientTestSubGroups  implements java.io.Serializable {


     private Integer orderSubGroupId;
     private TestVendor testVendor;
     private TestSubgroups testSubgroups;
     private TestGroups testGroups;
     private PatientTestGroups patientTestGroups;
     private PatientTestOrders patientTestOrders;
     private String createdBy;
     private Date createdDate;
     private String lastUpdatedBy;
     private Date lastUpdatedDate;
    

    public PatientTestSubGroups() {
    }

	
    public PatientTestSubGroups(TestSubgroups testSubgroups, TestGroups testGroups, PatientTestGroups patientTestGroups, PatientTestOrders patientTestOrders, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate) {
        this.testSubgroups = testSubgroups;
        this.testGroups = testGroups;
        this.patientTestGroups = patientTestGroups;
        this.patientTestOrders = patientTestOrders;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public PatientTestSubGroups(TestVendor testVendor, TestSubgroups testSubgroups, TestGroups testGroups, PatientTestGroups patientTestGroups, PatientTestOrders patientTestOrders, String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, Set patientTestses) {
       this.testVendor = testVendor;
       this.testSubgroups = testSubgroups;
       this.testGroups = testGroups;
       this.patientTestGroups = patientTestGroups;
       this.patientTestOrders = patientTestOrders;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.lastUpdatedBy = lastUpdatedBy;
       this.lastUpdatedDate = lastUpdatedDate;
      
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ORDER_SUB_GROUP_ID", unique=true, nullable=false)
    public Integer getOrderSubGroupId() {
        return this.orderSubGroupId;
    }
    
    public void setOrderSubGroupId(Integer orderSubGroupId) {
        this.orderSubGroupId = orderSubGroupId;
    }


    @Column(name="TEST_VENDOR_ID")
    public TestVendor getTestVendor() {
        return this.testVendor;
    }
    
    public void setTestVendor(TestVendor testVendor) {
        this.testVendor = testVendor;
    }


    @Column(name="TEST_SUBGROUP_ID", nullable=false)
    public TestSubgroups getTestSubgroups() {
        return this.testSubgroups;
    }
    
    public void setTestSubgroups(TestSubgroups testSubgroups) {
        this.testSubgroups = testSubgroups;
    }


    @Column(name="TEST_GROUP_ID", nullable=false)
    public TestGroups getTestGroups() {
        return this.testGroups;
    }
    
    public void setTestGroups(TestGroups testGroups) {
        this.testGroups = testGroups;
    }


    @Column(name="ORDER_GROUP_ID", nullable=false)
    public PatientTestGroups getPatientTestGroups() {
        return this.patientTestGroups;
    }
    
    public void setPatientTestGroups(PatientTestGroups patientTestGroups) {
        this.patientTestGroups = patientTestGroups;
    }


    @Column(name="ORDER_ID", nullable=false)
    public PatientTestOrders getPatientTestOrders() {
        return this.patientTestOrders;
    }
    
    public void setPatientTestOrders(PatientTestOrders patientTestOrders) {
        this.patientTestOrders = patientTestOrders;
    }

    
    @Column(name="CREATED_BY", nullable=false, length=60)
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", nullable=false, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="LAST_UPDATED_BY", nullable=false, length=60)
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }
    
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATED_DATE", nullable=false, length=19)
    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }
    
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }






}


