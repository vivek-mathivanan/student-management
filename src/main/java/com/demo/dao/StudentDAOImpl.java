 package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.api.Student;
import com.demo.rowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
		
		String sql = "Select * from students";
		List<Student> studentList  = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		
		Object[] sqlArgs = {student.getName(), student.getMobile(), student.getCountry()};
		String sql = "Insert into students(name,mobile,country) values(?,?,?)";
		
		jdbcTemplate.update(sql, sqlArgs);
		
	}

	@Override
	public Student getStudent(int id) {
		
		String sql = "Select * from students where id=?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
				
		return student;
	}

	@Override
	public void update(Student student) {

		String sql = "Update students set name=?, mobile=?, country=? where id=?";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getId());
		
	}

	@Override
	public void deleteStudent(int id) {

		String sql = "Delete from students where id = ?";
		jdbcTemplate.update(sql, id);
		
	}

}
