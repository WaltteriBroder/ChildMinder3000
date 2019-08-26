package fi.aldowaldo.childminder.dto;

import java.util.Objects;

public class ChildAndChildGroupDto {

    private Long childId;
    private Long groupId;

    public ChildAndChildGroupDto(Long childId, Long groupId) {
        this.childId = childId;
        this.groupId = groupId;
    }

    public ChildAndChildGroupDto() {
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
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
        if (!(o instanceof ChildAndChildGroupDto)) return false;
        ChildAndChildGroupDto dto = (ChildAndChildGroupDto) o;
        return Objects.equals(getChildId(), dto.getChildId()) &&
                Objects.equals(getGroupId(), dto.getGroupId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getChildId(), getGroupId());
    }
}
