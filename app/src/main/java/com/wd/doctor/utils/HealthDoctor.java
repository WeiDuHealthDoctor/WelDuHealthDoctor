package com.wd.doctor.utils;

import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.DepartmentBean;
import com.wd.doctor.bean.EmailCodeBean;
import com.wd.doctor.bean.InquireSickBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.bean.SettleinBean;
import com.wd.doctor.bean.SickCircleBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.utils
 * @ClassName: HealthDoctor
 * @Author: YuYanHe
 * @CreateDate: 2020/2/19 13:51
 */
public interface HealthDoctor {
    //查询系统形象照
    @GET("doctor/v1/findSystemImagePic")
    Observable<AvatarBean> getAvatar();

    //发送邮箱验证码
    @POST("doctor/v1/sendEmailCode")
    Observable<EmailCodeBean> getEmailCode(@Field("email") String email);

    //登录
    // @POST("doctor/v1/login")
    //Observable<> getLogin();


    //申请入驻
    @POST("doctor/v1/applyJoin")
    Observable<SettleinBean> getSettlein(@Field("email") String email, @Field("code") String code
            , @Field("pwd1") String pwd1, @Field("pwd2") String pwd2, @Field("name") String name
            , @Field("inauguralHospital") String inauguralHospital, @Field("departmentId") int departmentId
            , @Field("jobTitleId") int jobTitleId, @Field("personalProfile") String personalProfile
            , @Field("goodField") String goodField);


    //病友圈列表展示
    @GET("doctor/sickCircle/v1/findSickCircleList")
    Observable<PatientBean> getPatient(@Query("departmentId") int departmentId, @Query("page")
            int page, @Query("count") int count);

    //查询病友圈详情
    @GET("doctor/sickCircle/v1/findSickCircleInfo")
    Observable<SickCircleBean> getSickCircle(@Query("sickCircleId") int sickCircleId);

    //查询科室
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<DepartmentBean> getDepartment();

    //根据关键字查询病友圈
    @GET("doctor/sickCircle/v1/searchSickCircle")
    Observable<InquireSickBean> getSearchSickCircle(@Query("keyWord") String keyWord);

}
