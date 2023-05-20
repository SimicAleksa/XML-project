//-------------USERS-------------
const USERS_API_BASE_URL = "http://localhost:8000/api";

export const API_REGISTRATION_URL = USERS_API_BASE_URL + "/users/regular/register";
export const API_LOGIN_URL = USERS_API_BASE_URL + "/auth/login";
export const API_USER_INFO_URL = USERS_API_BASE_URL + "/users/info";
//-------------------------------


//-----------TRADEMARK-----------
const TRADEMARK_API_BASE_URL = "http://localhost:8069/api";
export const API_SEND_TRADEMARK_REQ_URL = TRADEMARK_API_BASE_URL + "/trademark/save";
//-------------------------------

//-----------PATENT-----------
//ovo je server.port u application.properties
const PATENT_API_BASE_URL = "http://localhost:8041/api";
export const API_SEND_PATENT_REQ_URL = PATENT_API_BASE_URL + "/patent/save";
//-------------------------------

