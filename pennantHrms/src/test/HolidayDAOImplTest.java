package test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DAO.HolidayDAOImpl;
import models.GradeHoliday;
import models.Holiday;
import models.HrmsJobGrade;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class HolidayDAOImplTest {

    @InjectMocks
    private HolidayDAOImpl holidayDAO;

    @Mock
    private EntityManager entityManager;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private CriteriaQuery<Holiday> criteriaQuery;

    @Mock
    private Root<Holiday> root;

    @Mock
    private TypedQuery<Holiday> holidayTypedQuery;

    @Mock
    private TypedQuery<GradeHoliday> gradeHolidayTypedQuery;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllHolidays() {
        List<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday());
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Holiday.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Holiday.class)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(criteriaBuilder.asc(root.get("hday_date"))).thenReturn(null);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(holidayTypedQuery);
        when(holidayTypedQuery.getResultList()).thenReturn(holidays);

        List<Holiday> result = holidayDAO.findAllHolidays();

        assertEquals(result, holidays);
        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Holiday.class);
        verify(criteriaQuery).from(Holiday.class);
        verify(criteriaQuery).select(root);
        verify(criteriaBuilder).asc(root.get("hday_date"));
        verify(entityManager).createQuery(criteriaQuery);
        verify(holidayTypedQuery).getResultList();
    }

    @Test
    public void testFindHolidayById() {
        GradeHoliday gradeHoliday = new GradeHoliday();
        String id = "123";
        when(entityManager.find(GradeHoliday.class, id)).thenReturn(gradeHoliday);

        GradeHoliday result = holidayDAO.findHolidayById(id);

        assertEquals(result, gradeHoliday);
        verify(entityManager).find(GradeHoliday.class, id);
    }

    @Test
    public void testFindAllGradeHolidays() {
        List<GradeHoliday> gradeHolidays = new ArrayList<>();
        gradeHolidays.add(new GradeHoliday());
        when(entityManager.createQuery("SELECT gh FROM GradeHoliday gh", GradeHoliday.class))
                .thenReturn(gradeHolidayTypedQuery);
        when(gradeHolidayTypedQuery.getResultList()).thenReturn(gradeHolidays);

        List<GradeHoliday> result = holidayDAO.findAllGradeHolidays();

        assertEquals(result, gradeHolidays);
        verify(entityManager).createQuery("SELECT gh FROM GradeHoliday gh", GradeHoliday.class);
        verify(gradeHolidayTypedQuery).getResultList();
    }

    @Test
    public void testFindAllOptedHolidays() {
        List<Holiday> holidays = new ArrayList<>();
        holidays.add(new Holiday());
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Holiday.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Holiday.class)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(criteriaBuilder.equal(root.get("hday_type"), "OPTN")).thenReturn(null);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(holidayTypedQuery);
        when(holidayTypedQuery.getResultList()).thenReturn(holidays);

        List<Holiday> result = holidayDAO.findAlloptedHolidays();

        assertEquals(result, holidays);
        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Holiday.class);
        verify(criteriaQuery).from(Holiday.class);
        verify(criteriaQuery).select(root);
        verify(criteriaBuilder).equal(root.get("hday_type"), "OPTN");
        verify(entityManager).createQuery(criteriaQuery);
        verify(holidayTypedQuery).getResultList();
    }
    @Test
    public void testCountMandHolidays() {
        Long count = 5L;
        CriteriaQuery<Long> countQuery = mock(CriteriaQuery.class);
        Root<Holiday> countRoot = mock(Root.class);
        Expression<Long> countExpression = mock(Expression.class);
        TypedQuery<Long> countTypedQuery = mock(TypedQuery.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Long.class)).thenReturn(countQuery);
        when(countQuery.from(Holiday.class)).thenReturn(countRoot);
        when(criteriaBuilder.count(countRoot)).thenReturn(countExpression);
        when(countQuery.select(countExpression)).thenReturn(countQuery);
        when(criteriaBuilder.equal(countRoot.get("hday_type"), "MAND")).thenReturn(null);
        when(entityManager.createQuery(countQuery)).thenReturn(countTypedQuery);
        when(countTypedQuery.getSingleResult()).thenReturn(count);

        int result = holidayDAO.countMandHolidays();

        assertEquals(result, count.intValue());
        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Long.class);
        verify(countQuery).from(Holiday.class);
        verify(criteriaBuilder).count(countRoot);
        verify(countQuery).select(countExpression);
        verify(criteriaBuilder).equal(countRoot.get("hday_type"), "MAND");
        verify(entityManager).createQuery(countQuery);
        verify(countTypedQuery).getSingleResult();
    }


    public void testGetEmployeeoptionalholidaysCount() {
        int id = 123;
        int year = 2023;
        Long count = 5L;
        String jpqlQuery = "SELECT COUNT(e) FROM EmployeeOptedLeaves e WHERE e.optedleavesId.employeeId = :employeeId AND  EXTRACT(YEAR FROM e.optedleavesId.holidayDate) = :year";
        TypedQuery<Long> countQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(jpqlQuery, Long.class)).thenReturn(countQuery);
        when(countQuery.setParameter("employeeId", id)).thenReturn(countQuery);
        when(countQuery.setParameter("year", year)).thenReturn(countQuery);
        when(countQuery.getSingleResult()).thenReturn(count);

        long result = holidayDAO.getEmployeeoptionalholidaysCount(id, year);

        assertEquals(result, count.longValue());
        verify(entityManager).createQuery(jpqlQuery, Long.class);
        verify(countQuery).setParameter("employeeId", id);
        verify(countQuery).setParameter("year", year);
        verify(countQuery).getSingleResult();
    }

    @Test
    public void testGetAllJobGradesInfo() {
        List<HrmsJobGrade> jobGrades = new ArrayList<>();
        jobGrades.add(new HrmsJobGrade());
        
        TypedQuery<HrmsJobGrade> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery(eq("SELECT jg FROM HrmsJobGrade jg"), eq(HrmsJobGrade.class)))
                .thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(jobGrades);

        List<HrmsJobGrade> result = holidayDAO.getAllJobGradesInfo();

        assertEquals(result, jobGrades);
        verify(entityManager).createQuery(eq("SELECT jg FROM HrmsJobGrade jg"), eq(HrmsJobGrade.class));
        verify(typedQuery).getResultList();
    }






    @Test
    public void testSaveJobGrade() {
        HrmsJobGrade jobGrade = new HrmsJobGrade();
        holidayDAO.saveJobGrade(jobGrade);
        verify(entityManager).persist(jobGrade);
    }

    @Test
    public void testSaveJobGradeHoliday() {
        GradeHoliday gradeHoliday = new GradeHoliday();
        holidayDAO.saveJobGradeHoliday(gradeHoliday);
        verify(entityManager).persist(gradeHoliday);
    }

    @Test
    public void testUpdateJobGradeHoliday() {
        GradeHoliday gradeHoliday = new GradeHoliday();
        GradeHoliday holidayData = new GradeHoliday();
        when(entityManager.find(GradeHoliday.class, gradeHoliday.getJbgr_id())).thenReturn(holidayData);

        holidayDAO.updateJobGradeHoliday(gradeHoliday);

        assertEquals(holidayData.getJbgr_totalnoh(), gradeHoliday.getJbgr_totalnoh());
        verify(entityManager).find(GradeHoliday.class, gradeHoliday.getJbgr_id());
        verify(entityManager).merge(holidayData);
    }
}
