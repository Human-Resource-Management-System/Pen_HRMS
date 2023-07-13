package test;

import static org.mockito.Mockito.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;


import DAO_Interfaces.ApplyPermissionDAO;
import controllers.PermissionsController;
import models.ApplyPermissions;
import models.Employee;
import models.PermissionCompositeKey;
import models.input.output.PermissionAdminModel;
import models.input.output.PermissionInputModel;

public class PermissionsControllerTest {

  @Mock
  private ApplyPermissionDAO mockApplyPermissionDAO;

  @Mock
  private ApplyPermissions mockApplyPermissions;

  @Mock
  private PermissionCompositeKey mockPermissionCompositeKey;

  @Mock
  private HttpSession mockHttpSession;

  @Mock
  private Model mockModel;

  @InjectMocks
  private PermissionsController permissionsController;

  @BeforeMethod
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(mockHttpSession.getAttribute("employeeId")).thenReturn(1);
  }

  
  @Test
  public void testAdminViewPermissionRequests() {
	// Arrange
	  Employee mockEmployee = new Employee();
	  mockEmployee.setEmplId(1);

	  ApplyPermissions mockPermission = new ApplyPermissions();
	  when(mockApplyPermissionDAO.getEmployeeAndPermissionRequestData(anyInt(), any(Date.class))).thenReturn(mockPermission);
	  when(mockApplyPermissionDAO.getEmployeesByHRAndManager(anyInt())).thenReturn(List.of(mockEmployee));

	  // Set the "adminId" attribute in the HttpSession mock
	  when(mockHttpSession.getAttribute("adminId")).thenReturn(1);

	  // Act
	  String viewName = permissionsController.adminViewPermissionRequests(mockModel, mockHttpSession);

	  // Assert
	  Assert.assertEquals(viewName, "adminviewpermission");
	  verify(mockModel).addAttribute(eq("permissions"), anyList());
  }


  @Test
  public void testAcceptPermission_Success() {
      // Arrange
      PermissionAdminModel permissionAdminModel = new PermissionAdminModel();
      permissionAdminModel.setId(1);
      permissionAdminModel.setIndex(1);

      ApplyPermissions mockPermission = new ApplyPermissions();
      when(mockApplyPermissionDAO.getPermissionByIdAndIndex(anyInt(), anyInt())).thenReturn(mockPermission);
      doNothing().when(mockApplyPermissionDAO).persist(any(ApplyPermissions.class));

      // Set the "adminId" attribute in the HttpSession mock
      when(mockHttpSession.getAttribute("adminId")).thenReturn(1);

      // Act
      ResponseEntity<String> response = permissionsController.acceptPermission(permissionAdminModel, mockHttpSession);

      // Assert
      Assert.assertEquals(response.getStatusCodeValue(), 200);
      Assert.assertEquals(response.getBody(), "success");
  }


  @Test
  public void testRejectPermission_Success() {
    // Arrange
    PermissionAdminModel permissionAdminModel = new PermissionAdminModel();
    permissionAdminModel.setId(1);
    permissionAdminModel.setIndex(1);

    ApplyPermissions mockPermission = new ApplyPermissions();
    when(mockApplyPermissionDAO.getPermissionByIdAndIndex(anyInt(), anyInt())).thenReturn(mockPermission);
    doNothing().when(mockApplyPermissionDAO).persist(any(ApplyPermissions.class));

    // Act
    ResponseEntity<String> response = permissionsController.rejectPermission(permissionAdminModel);

    // Assert
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(response.getBody(), "success");
  }

  @Test
  public void testGetPermissionsCount_Success() {
    // Arrange
    when(mockHttpSession.getAttribute("employeeId")).thenReturn(1);
    when(mockApplyPermissionDAO.getEmployeeApprovedPermissionsCount(anyInt(), anyInt())).thenReturn(5L);
    Gson gson = new Gson();
    PermissionsController controller = new PermissionsController(mockApplyPermissionDAO, mockApplyPermissions,
        mockPermissionCompositeKey, gson);

    // Act
    ResponseEntity<String> response = controller.getPermissionsCount(mockHttpSession);

    // Assert
    Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    Assert.assertEquals(response.getBody(), gson.toJson(5L));
  }

  @Test
  public void testGetPermissionsStatusAtEmp_Success() {
      // Arrange
      when(mockHttpSession.getAttribute("employeeId")).thenReturn(1);
      List<ApplyPermissions> mockListOfPermission = new ArrayList<>();
      when(mockApplyPermissionDAO.appliedPermissions(anyInt())).thenReturn(mockListOfPermission);
      Gson gson = new Gson(); // Create a new Gson instance
      PermissionsController controller = new PermissionsController(mockApplyPermissionDAO, mockApplyPermissions,
          mockPermissionCompositeKey, gson);

      // Capture the model attribute using ArgumentCaptor
      ArgumentCaptor<String> attributeNameCaptor = ArgumentCaptor.forClass(String.class);
      ArgumentCaptor<Object> attributeValueCaptor = ArgumentCaptor.forClass(Object.class);

      // Use thenReturn() instead of doNothing()
      when(mockModel.addAttribute(attributeNameCaptor.capture(), attributeValueCaptor.capture()))
          .thenReturn(mockModel);

      // Act
      String viewName = controller.getPermissionsStatusAtEmp(mockHttpSession, mockModel);

      // Logging statements
      System.out.println("View Name: " + viewName);
      System.out.println("Captured Attribute Name: " + attributeNameCaptor.getValue());
      System.out.println("Captured Attribute Value: " + attributeValueCaptor.getValue());

      // Assert
      Assert.assertEquals(viewName, "empViewPermissions");
      Assert.assertEquals(attributeNameCaptor.getValue(), "listOfPermission");
      Assert.assertEquals(attributeValueCaptor.getValue(), mockListOfPermission);
  }


}
