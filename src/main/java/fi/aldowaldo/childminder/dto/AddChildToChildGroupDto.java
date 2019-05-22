package fi.aldowaldo.childminder.dto;

public class AddChildToChildGroupDto {

    private Long childId;
    private Long groupId;

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
}
