package fi.aldowaldo.childminder.dto;

import java.util.Objects;

public class TeacherChildgroupDto {

    private Long teacherId;
    private Long groupId;

    public TeacherChildgroupDto(Long teacherId, Long groupId) {
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public TeacherChildgroupDto() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherChildgroupDto)) return false;
        TeacherChildgroupDto dto = (TeacherChildgroupDto) o;
        return Objects.equals(getTeacherId(), dto.getTeacherId()) &&
                Objects.equals(getGroupId(), dto.getGroupId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTeacherId(), getGroupId());
    }

    @Override
    public String toString() {
        return "TeacherChildgroupDto{" +
                "teacherId=" + teacherId +
                ", groupId=" + groupId +
                '}';
    }
}
