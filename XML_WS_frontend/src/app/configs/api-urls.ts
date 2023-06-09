//-------------USERS-------------
const USERS_API_BASE_URL = "http://localhost:8000/api";

export const API_REGISTRATION_URL = USERS_API_BASE_URL + "/users/regular/register";
export const API_LOGIN_URL = USERS_API_BASE_URL + "/auth/login";
export const API_USER_INFO_URL = USERS_API_BASE_URL + "/users/info";
//-------------------------------


//-----------TRADEMARK-----------
const TRADEMARK_API_BASE_URL = "http://localhost:8069/api";
export const API_SEND_TRADEMARK_REQ_URL = TRADEMARK_API_BASE_URL + "/trademark/save";
export const API_FETCH_PENDING_TM_REQS_URL = TRADEMARK_API_BASE_URL + "/trademark/pending";
export const API_GEN_TM_PDF = TRADEMARK_API_BASE_URL + "/trademark/pdf/";
export const API_GEN_TM_XHTML = TRADEMARK_API_BASE_URL + "/trademark/xhtml/";
export const API_SEND_TM_RESENJE = TRADEMARK_API_BASE_URL + "/trademark/resenje/save";
export const API_TM_BASIC_SEARCH = TRADEMARK_API_BASE_URL + "/trademark/search/basic";
export const API_TM_ADVANCED_SEARCH = TRADEMARK_API_BASE_URL + "/trademark/search/advanced";
export const API_TM_RDF = TRADEMARK_API_BASE_URL + "/trademark/metadata/rdf";
export const API_TM_JSON = TRADEMARK_API_BASE_URL + "/trademark/metadata/json";
export const API_TM_REPORT = TRADEMARK_API_BASE_URL + "/trademark/report";
//-------------------------------

//-----------PATENT-----------
//ovo je server.port u application.properties
const PATENT_API_BASE_URL = "http://localhost:8041/api";
export const API_SEND_PATENT_REQ_URL = PATENT_API_BASE_URL + "/patent/save";
export const API_FETCH_PENDING_PAT_REQS_URL = PATENT_API_BASE_URL + "/patent/pending";
export const API_GEN_PAT_XHTML = PATENT_API_BASE_URL + "/patent/xhtml/";
export const API_GEN_PAT_PDF = PATENT_API_BASE_URL + "/patent/pdf/";
export const API_SEND_PAT_RESENJE = PATENT_API_BASE_URL + "/patent/resenje/save";
export const API_PAT_BASIC_SEARCH = PATENT_API_BASE_URL + "/patent/search/basic";
export const API_PAT_ADVANCED_SEARCH = PATENT_API_BASE_URL + "/patent/search/advanced";
export const API_PAT_RDF = PATENT_API_BASE_URL + "/patent/metadata/rdf";
export const API_PAT_JSON = PATENT_API_BASE_URL + "/patent/metadata/json";
export const API_PAT_REPORT = PATENT_API_BASE_URL + "/patent/report";
export const API_PAT_REFERANCED_SEARCH = PATENT_API_BASE_URL + "/patent/reference";
//-------------------------------


//-----------COPYRIGHT-----------
//ovo je server.port u application.properties
const COPYRIGHT_API_BASE_URL = "http://localhost:8021/api";
export const API_SEND_CR_REQ_URL = COPYRIGHT_API_BASE_URL + "/author-rights/save";
export const API_FETCH_PENDING_CR_REQS_URL = COPYRIGHT_API_BASE_URL + "/author-rights/pending";
export const API_GEN_CR_XHTML = COPYRIGHT_API_BASE_URL + "/author-rights/xhtml/";
export const API_GEN_CR_PDF = COPYRIGHT_API_BASE_URL + "/author-rights/pdf/";
export const API_SEND_CR_RESENJE = COPYRIGHT_API_BASE_URL + "/author-rights/resenje/save";
export const API_CR_BASIC_SEARCH = COPYRIGHT_API_BASE_URL + "/author-rights/search/basic";
export const API_CR_ADVANCED_SEARCH = COPYRIGHT_API_BASE_URL + "/author-rights/search/advanced";
export const API_CR_RDF = COPYRIGHT_API_BASE_URL + "/author-rights/metadata/rdf";
export const API_CR_JSON = COPYRIGHT_API_BASE_URL + "/author-rights/metadata/json";
export const API_CR_REPORT = COPYRIGHT_API_BASE_URL + "/author-rights/report";
//-------------------------------

