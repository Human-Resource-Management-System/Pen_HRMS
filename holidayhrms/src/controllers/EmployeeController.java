package controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO_Interfaces.EmployeeDAO;
import models.Employee;
import models.EmployeeParameter;
import models.input.output.EmployeeOutput;
import models.input.output.EmployeeParameterIO;
import service.EmpService;

@Controller
public class EmployeeController {

	private final EmployeeDAO emp;
	private final ModelMapper modelMapper;
	private final EmpService empserv;
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	public EmployeeController(EmployeeDAO ed, ModelMapper mp, EmpService empserv) {
		emp = ed;
		modelMapper = mp;
		this.empserv = empserv;

	}

	// To display employees list
	@RequestMapping("/employees")
	public String showEmployeeList(Model model, HttpSession session) {
		logger.info("Requested for the list of employees");
		List<Employee> employees = emp.getAllEmployees(session);
		List<EmployeeOutput> employeeOutputs = modelMapper.map(employees, new TypeToken<List<EmployeeOutput>>() {
		}.getType());
		logger.info("Dispayed for the list of employees");

		model.addAttribute("employees", employeeOutputs);
		return "employees";
	}

	// To display the details of a particular employee
	@RequestMapping("/get-employee-details")
	public String getEmployeeDetails(@RequestParam("id") int employeeId, Model model) {
		logger.info("Requested for particular employee details");

		Employee employee = emp.getEmployeeById(employeeId);
		EmployeeOutput eout = modelMapper.map(employee, new TypeToken<EmployeeOutput>() {
		}.getType());
		logger.info("Displayed particular employee details");

		model.addAttribute("employee", eout);
		return "get-employee-details";
	}

	// Form to insert employee details
	@RequestMapping(value = "/addempl", method = RequestMethod.GET)
	public String addEmployee() {
		logger.info("Requested for adding new employee");

		return "addempl";
	}

	// To display list of employees after insertion of a new employee
	@RequestMapping(value = "/employeeList", method = RequestMethod.POST)
	public String insertedEmployeeList(@ModelAttribute Employee emps, Model model, HttpSession session) {

		emps.setEmplLuuser(301);
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		emps.setEmplLuudate(currentTimestamp);
		emp.insertEmployee(emps);

		List<Employee> employees = emp.getAllEmployees(session);
		List<EmployeeOutput> eout = modelMapper.map(employees, new TypeToken<List<EmployeeOutput>>() {
		}.getType());
		model.addAttribute("employees", eout);
		return "employees";
	}

	// To delete an employee(Soft delete)
	@RequestMapping(value = "/delempl")
	public String deleteEmployee(Model model) {
		logger.info("Requested for deleting employees");

		return "delempl";
	}

	// To display list of employees after deletion of an employee
	@PostMapping(value = "/employeeListDelete")
	public String deletedEmployeeList(@RequestParam("emplId") int emplId, Model model, HttpSession session) {
		emp.updateEmployeeStatus(emplId, "deleted");
		logger.info("Requested for the list of employees after deleting a particular employee");

		List<Employee> employees = emp.getAllEmployees(session);
		List<EmployeeOutput> employeeOutputs = modelMapper.map(employees, new TypeToken<List<EmployeeOutput>>() {
		}.getType());
		model.addAttribute("employees", employeeOutputs);
		return "employees";
	}

	// Form to update the details of an employee
	@RequestMapping(value = "/updempl", method = RequestMethod.GET)
	public String updateEmployeeDetails(@RequestParam("id") int emplId, Model model) {
		Employee existingEmployee = emp.getEmployeeById(emplId);
		logger.info("Requested for updating employees");
		EmployeeOutput eout = modelMapper.map(existingEmployee, new TypeToken<EmployeeOutput>() {
		}.getType());
		model.addAttribute("updating", eout);
		System.out.println("route");
		return "updempl";
	}

	// To show the status of the employee update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStatus(@ModelAttribute EmployeeOutput empst, Model model, HttpSession session) {
		Employee erm = modelMapper.map(empst, new TypeToken<Employee>() {
		}.getType());
		erm.setEmplLuuser((int) session.getAttribute("adminId"));
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		erm.setEmplLuudate(currentTimestamp);
		emp.updateEmployee(erm);
		logger.info("Employee details have been updated successfully ");
		model.addAttribute("message", "Employee details updated successfully!");
		return "update";
	}

	// To view the parameters of an employee
	@RequestMapping("/emplparam")
	public String getEmployeeParameters(@RequestParam("id") Integer employeeId, Model model) {
		List<EmployeeParameter> employeeParameters = emp.getEmployeeParametersById(employeeId);
		List<EmployeeParameterIO> ep = modelMapper.map(employeeParameters, new TypeToken<List<EmployeeParameterIO>>() {
		}.getType());
		logger.info("Requested for viewing parameter of employee");
		model.addAttribute("employeeParameters", ep);
		return "employeeparamaters";
	}

	// To display the employee profile
	@RequestMapping(value = "/toprofile", method = RequestMethod.GET)
	public String showEmployeeProfile(Model model, HttpSession session) {
		logger.info("Employee Requested for displaying profile");

		System.out.println("this is sp_orm controller getting employes method ");
		// System.out.println("");
		Employee empdetails = emp.getEmployeeById((int) session.getAttribute("employeeId"));
		EmployeeOutput eout = modelMapper.map(empdetails, new TypeToken<EmployeeOutput>() {
		}.getType());
		model.addAttribute("empdet", eout);
		return "profile";
	}

	// To display the admin profile
	@RequestMapping(value = "/toprofileadmin", method = RequestMethod.GET)
	public String showAdminProfile(Model model, HttpSession session) {
		logger.info("Admin Requested for displaying profile");

		System.out.println("this is sp_orm controller getting employes method ");
		Employee empdetails = emp.getEmployeeById((int) session.getAttribute("adminId"));
		EmployeeOutput eout = modelMapper.map(empdetails, new TypeToken<EmployeeOutput>() {
		}.getType());
		model.addAttribute("empdet", eout);
		return "profile";
	}

	// To update the address in the employee profile
	@RequestMapping(value = "/update_address", method = RequestMethod.POST)
	public ResponseEntity<String> updateAddress(@ModelAttribute EmployeeOutput emp, Model model) {
		logger.info("REquested for updating address of an employee ");

		Employee erm = modelMapper.map(emp, new TypeToken<Employee>() {
		}.getType());
		empserv.updateAddress(erm.getEmplId(), erm.getEmplAddress());
		logger.info("Updated address of an employee ");

		return ResponseEntity.ok("success");

	}

}