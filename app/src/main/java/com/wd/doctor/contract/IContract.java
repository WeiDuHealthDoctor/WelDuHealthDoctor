package com.wd.doctor.contract;

import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.DepartmentBean;
import com.wd.doctor.bean.InquireSickBean;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.bean.SettleinBean;
import com.wd.doctor.bean.SickCircleBean;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.contract
 * @ClassName: IContract
 * @Author: YuYanHe
 * @CreateDate: 2020/1/8 18:48
 */
public interface IContract {
    //查询系统形象照
    interface IViewAvatar {
        void avatarSuccess(AvatarBean avatarBean);
    }

    //查询系统形象照
    interface IModelAvatar {
        void avatarsSuccess(AvatarBean avatarBean);
    }

    //病友圈列表展示
    interface IViewPatient {
        void patientSuccess(PatientBean patientBean);
    }

    //病友圈列表展示
    interface IModelPatient {
        void patientsSuccess(PatientBean patientBean);
    }

    //申请入驻
    interface IViewSettlein {
        void settleinSuccess(SettleinBean settleinBean);
    }

    //申请入驻
    interface IModelSettlein {
        void settleinsSuccess(SettleinBean settleinBean);
    }

    //查询病友圈详情
    interface IViewSickCircle {
        void sickCircleSuccess(SickCircleBean sickCircleBean);
    }

    //查询病友圈详情
    interface IModelSickCircle {
        void sickCirclesSuccess(SickCircleBean sickCircleBean);
    }

    //查询科室
    interface IViewDepartment {
        void departmentSuccess(DepartmentBean departmentBean);
    }

    //查询科室
    interface IModelDepartment {
        void departmentesSuccess(DepartmentBean departmentBean);
    }

    //根据关键词查询病友圈
    interface IViewInquire {
        void InquireSuccess(InquireSickBean inquireSickBean);
    }

    //根据关键词查询病友圈
    interface IModelInquire {
        void InquiresSuccess(InquireSickBean inquireSickBean);
    }

    //登录
    interface IViewLogin {
        void LoginSuccess(LoginBean loginBean);
    }

    //登录
    interface IModelLogin {
        void LoginsSuccess(LoginBean loginBean);
    }
}
