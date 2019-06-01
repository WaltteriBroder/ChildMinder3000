package fi.aldowaldo.childminder.dto;

public class AssignChildGroupToTeacherDto {

    private Long teacherId;
    private Long groupId;

    public AssignChildGroupToTeacherDto(Long teacherId, Long groupId) {
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public AssignChildGroupToTeacherDto() {
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "AssignChildGroupToTeacherDto{" +
                "teacherId=" + teacherId +
                ", groupId=" + groupId +
                '}';
    }
}
