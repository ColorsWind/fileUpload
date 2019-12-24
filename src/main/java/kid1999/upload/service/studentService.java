package kid1999.upload.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import kid1999.upload.mapper.studentMapper;
import kid1999.upload.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

	@Autowired
	private studentMapper studentMapper;


	// 用workid 和 sname 查询是否已经提交过
	public Student getStudentBySname(int workid, String sname) {
		QueryWrapper<Student> wrapper = new QueryWrapper<>();
		wrapper.eq("workid",workid).eq("name",sname);
		return studentMapper.selectOne(wrapper);
	}

	// 添加student
	public int addStudent(Student newStudent) {
		return studentMapper.insert(newStudent);
	}

	// 更新student
	public int updateStudent(Student student) {
		QueryWrapper<Student> wrapper = new QueryWrapper<>();
		wrapper.eq("id",student.getId())
				.eq("name",student.getName());
		return studentMapper.update(student,wrapper);
	}

	// 匹配filname 的student记录
	public List<Student> findStuByfilename(String filename) {
		return studentMapper.findStuByfilename(filename);
	}


	// 删除一个学生提交信息
	public void deleteStudentById(int studentId) {
		studentMapper.deleteById(studentId);
	}

	// 查询提交信息 通过 workid
	public List<Student> getStudentsByWorkId(String workid, int pageNo, int pageSize) {
		IPage<Student> page = new Page<>(pageNo, pageSize);
		QueryWrapper<Student> wrapper = new QueryWrapper<>();
		wrapper.eq("workid",workid);
		IPage<Student> studentIPage = studentMapper.selectPage(page, wrapper);
		return studentIPage.getRecords();
	}
}
