package com.framgia.fdms.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by levutantuan on 3/31/17.
 */
public class User {
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("first_name")
    private String mFirstName;
    @Expose
    @SerializedName("last_name")
    private String mLastName;
    @Expose
    @SerializedName("email")
    private String mEmail;
    @Expose
    @SerializedName("address")
    private String mAddress;
    @Expose
    @SerializedName("password_digest")
    private String mPasswordDigest;
    @Expose
    @SerializedName("reset_digest")
    private String mResetDigest;
    @Expose
    @SerializedName("created_by")
    private String mCreatedBy;
    @Expose
    @SerializedName("updated_by")
    private String mUpdatedBy;
    @Expose
    @SerializedName("created_at")
    private Date mCreatedAt;
    @Expose
    @SerializedName("updated_at")
    private Date mUpdatedAt;
    @Expose
    @SerializedName("remember_digest")
    private String mRememberDigest;
    @Expose
    @SerializedName("avatar")
    private Picture mAvatar;
    @Expose
    @SerializedName("from_excel")
    private boolean mFromExcel;
    @Expose
    @SerializedName("gender")
    private String mGender;
    @Expose
    @SerializedName("role")
    private String mRole;
    @Expose
    @SerializedName("birthday")
    private Date mBirthday;
    @Expose
    @SerializedName("employee_code")
    private String mEmployeeCode;
    @Expose
    @SerializedName("status")
    private String mStatus;
    @Expose
    @SerializedName("contract_date")
    private Date mContractDate;
    @Expose
    @SerializedName("start_probation_date")
    private Date mStartProbationDate;
    @Expose
    @SerializedName("end_probation_date")
    private Date mEndProbationDate;
    @Expose
    @SerializedName("token")
    private String mToken;

    public User() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPasswordDigest() {
        return mPasswordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        mPasswordDigest = passwordDigest;
    }

    public String getResetDigest() {
        return mResetDigest;
    }

    public void setResetDigest(String resetDigest) {
        mResetDigest = resetDigest;
    }

    public String getCreatedBy() {
        return mCreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        mCreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return mUpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        mUpdatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getRememberDigest() {
        return mRememberDigest;
    }

    public void setRememberDigest(String rememberDigest) {
        mRememberDigest = rememberDigest;
    }

    public Picture getAvatar() {
        return mAvatar;
    }

    public void setAvatar(Picture avatar) {
        mAvatar = avatar;
    }

    public boolean isFromExcel() {
        return mFromExcel;
    }

    public void setFromExcel(boolean fromExcel) {
        mFromExcel = fromExcel;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public Date getBirthday() {
        return mBirthday;
    }

    public void setBirthday(Date birthday) {
        mBirthday = birthday;
    }

    public String getEmployeeCode() {
        return mEmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        mEmployeeCode = employeeCode;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Date getContractDate() {
        return mContractDate;
    }

    public void setContractDate(Date contractDate) {
        mContractDate = contractDate;
    }

    public Date getStartProbationDate() {
        return mStartProbationDate;
    }

    public void setStartProbationDate(Date startProbationDate) {
        mStartProbationDate = startProbationDate;
    }

    public Date getEndProbationDate() {
        return mEndProbationDate;
    }

    public void setEndProbationDate(Date endProbationDate) {
        mEndProbationDate = endProbationDate;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}
