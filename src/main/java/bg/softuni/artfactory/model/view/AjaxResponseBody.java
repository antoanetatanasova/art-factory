package bg.softuni.artfactory.model.view;

import bg.softuni.artfactory.model.entity.UserEntity;

import java.util.List;

public class AjaxResponseBody {
    String msg;
    List<UserEntity> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UserEntity> getResult() {
        return result;
    }

    public void setResult(List<UserEntity> result) {
        this.result = result;
    }

}
