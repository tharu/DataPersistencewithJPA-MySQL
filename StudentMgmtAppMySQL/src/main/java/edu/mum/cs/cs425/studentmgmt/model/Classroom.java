package edu.mum.cs.cs425.studentmgmt.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="classrooms")
public class Classroom 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int classroomId;	
	private String buildingName;
	private String roomNumber;
	@ManyToMany(mappedBy = "classroomList", cascade = CascadeType.MERGE)
	private List<Student> studentList;
	

	public Classroom()
	{
		
	}
	
	public Classroom(String buildingName, String roomNumber) 
	{
		this.buildingName=buildingName;
		this.roomNumber=roomNumber;		
	}
	
	public int getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	
}
