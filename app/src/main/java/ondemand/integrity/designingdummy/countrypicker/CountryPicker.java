package ondemand.integrity.designingdummy.countrypicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import ondemand.integrity.designingdummy.R;

public class CountryPicker {

    // region Countries
    public static final Country[] COUNTRIES = {
            new Country("AD", "Andorra", "+376", R.mipmap.flag_ad, "EUR"),
            new Country("AE", "United Arab Emirates", "+971", R.mipmap.flag_ae, "AED"),
            new Country("AF", "Afghanistan", "+93", R.mipmap.flag_af, "AFN"),
            new Country("AG", "Antigua and Barbuda", "+1", R.mipmap.flag_ag, "XCD"),
            new Country("AI", "Anguilla", "+1", R.mipmap.flag_ai, "XCD"),
            new Country("AL", "Albania", "+355", R.mipmap.flag_al, "ALL"),
            new Country("AM", "Armenia", "+374", R.mipmap.flag_am, "AMD"),
            new Country("AO", "Angola", "+244", R.mipmap.flag_ao, "AOA"),
            new Country("AQ", "Antarctica", "+672", R.mipmap.flag_aq, "USD"),
            new Country("AR", "Argentina", "+54", R.mipmap.flag_ar, "ARS"),
            new Country("AS", "American Samoa", "+1", R.mipmap.flag_as, "USD"),
            new Country("AT", "Austria", "+43", R.mipmap.flag_at, "EUR"),
            new Country("AU", "Australia", "+61", R.mipmap.flag_au, "AUD"),
            new Country("AW", "Aruba", "+297", R.mipmap.flag_aw, "AWG"),
            new Country("AX", "Aland Islands", "+358", R.mipmap.flag_ax, "EUR"),
            new Country("AZ", "Azerbaijan", "+994", R.mipmap.flag_az, "AZN"),
            new Country("BA", "Bosnia and Herzegovina", "+387", R.mipmap.flag_ba, "BAM"),
            new Country("BB", "Barbados", "+1", R.mipmap.flag_bb, "BBD"),
            new Country("BD", "Bangladesh", "+880", R.mipmap.flag_bd, "BDT"),
            new Country("BE", "Belgium", "+32", R.mipmap.flag_be, "EUR"),
            new Country("BF", "Burkina Faso", "+226", R.mipmap.flag_bf, "XOF"),
            new Country("BG", "Bulgaria", "+359", R.mipmap.flag_bg, "BGN"),
            new Country("BH", "Bahrain", "+973", R.mipmap.flag_bh, "BHD"),
            new Country("BI", "Burundi", "+257", R.mipmap.flag_bi, "BIF"),
            new Country("BJ", "Benin", "+229", R.mipmap.flag_bj, "XOF"),
            new Country("BL", "Saint Barthelemy", "+590", R.mipmap.flag_bl, "EUR"),
            new Country("BM", "Bermuda", "+1", R.mipmap.flag_bm, "BMD"),
            new Country("BN", "Brunei Darussalam", "+673", R.mipmap.flag_bn, "BND"),
            new Country("BO", "Bolivia, Plurinational State of", "+591", R.mipmap.flag_bo, "BOB"),
            new Country("BQ", "Bonaire", "+599", R.mipmap.flag_bq, "USD"),
            new Country("BR", "Brazil", "+55", R.mipmap.flag_br, "BRL"),
            new Country("BS", "Bahamas", "+1", R.mipmap.flag_bs, "BSD"),
            new Country("BT", "Bhutan", "+975", R.mipmap.flag_bt, "BTN"),
            new Country("BV", "Bouvet Island", "+47", R.mipmap.flag_bv, "NOK"),
            new Country("BW", "Botswana", "+267", R.mipmap.flag_bw, "BWP"),
            new Country("BY", "Belarus", "+375", R.mipmap.flag_by, "BYR"),
            new Country("BZ", "Belize", "+501", R.mipmap.flag_bz, "BZD"),
            new Country("CA", "Canada", "+1", R.mipmap.flag_ca, "CAD"),
            new Country("CC", "Cocos (Keeling) Islands", "+61", R.mipmap.flag_cc, "AUD"),
            new Country("CD", "Congo, The Democratic Republic of the", "+243", R.mipmap.flag_cd, "CDF"),
            new Country("CF", "Central African Republic", "+236", R.mipmap.flag_cf, "XAF"),
            new Country("CG", "Congo", "+242", R.mipmap.flag_cg, "XAF"),
            new Country("CH", "Switzerland", "+41", R.mipmap.flag_ch, "CHF"),
            new Country("CI", "Ivory Coast", "+225", R.mipmap.flag_ci, "XOF"),
            new Country("CK", "Cook Islands", "+682", R.mipmap.flag_ck, "NZD"),
            new Country("CL", "Chile", "+56", R.mipmap.flag_cl, "CLP"),
            new Country("CM", "Cameroon", "+237", R.mipmap.flag_cm, "XAF"),
            new Country("CN", "China", "+86", R.mipmap.flag_cn, "CNY"),
            new Country("CO", "Colombia", "+57", R.mipmap.flag_co, "COP"),
            new Country("CR", "Costa Rica", "+506", R.mipmap.flag_cr, "CRC"),
            new Country("CU", "Cuba", "+53", R.mipmap.flag_cu, "CUP"),
            new Country("CV", "Cape Verde", "+238", R.mipmap.flag_cv, "CVE"),
            new Country("CW", "Curacao", "+599", R.mipmap.flag_cw, "ANG"),
            new Country("CX", "Christmas Island", "+61", R.mipmap.flag_cx, "AUD"),
            new Country("CY", "Cyprus", "+357", R.mipmap.flag_cy, "EUR"),
            new Country("CZ", "Czech Republic", "+420", R.mipmap.flag_cz, "CZK"),
            new Country("DE", "Germany", "+49", R.mipmap.flag_de, "EUR"),
            new Country("DJ", "Djibouti", "+253", R.mipmap.flag_dj, "DJF"),
            new Country("DK", "Denmark", "+45", R.mipmap.flag_dk, "DKK"),
            new Country("DM", "Dominica", "+1", R.mipmap.flag_dm, "XCD"),
            new Country("DO", "Dominican Republic", "+1", R.mipmap.flag_do, "DOP"),
            new Country("DZ", "Algeria", "+213", R.mipmap.flag_dz, "DZD"),
            new Country("EC", "Ecuador", "+593", R.mipmap.flag_ec, "USD"),
            new Country("EE", "Estonia", "+372", R.mipmap.flag_ee, "EUR"),
            new Country("EG", "Egypt", "+20", R.mipmap.flag_eg, "EGP"),
            new Country("EH", "Western Sahara", "+212", R.mipmap.flag_eh, "MAD"),
            new Country("ER", "Eritrea", "+291", R.mipmap.flag_er, "ERN"),
            new Country("ES", "Spain", "+34", R.mipmap.flag_es, "EUR"),
            new Country("ET", "Ethiopia", "+251", R.mipmap.flag_et, "ETB"),
            new Country("FI", "Finland", "+358", R.mipmap.flag_fi, "EUR"),
            new Country("FJ", "Fiji", "+679", R.mipmap.flag_fj, "FJD"),
            new Country("FK", "Falkland Islands (Malvinas)", "+500", R.mipmap.flag_fk, "FKP"),
            new Country("FM", "Micronesia, Federated States of", "+691", R.mipmap.flag_fm, "USD"),
            new Country("FO", "Faroe Islands", "+298", R.mipmap.flag_fo, "DKK"),
            new Country("FR", "France", "+33", R.mipmap.flag_fr, "EUR"),
            new Country("GA", "Gabon", "+241", R.mipmap.flag_ga, "XAF"),
            new Country("GB", "United Kingdom", "+44", R.mipmap.flag_gb, "GBP"),
            new Country("GD", "Grenada", "+1", R.mipmap.flag_gd, "XCD"),
            new Country("GE", "Georgia", "+995", R.mipmap.flag_ge, "GEL"),
            new Country("GF", "French Guiana", "+594", R.mipmap.flag_gf, "EUR"),
            new Country("GG", "Guernsey", "+44", R.mipmap.flag_gg, "GGP"),
            new Country("GH", "Ghana", "+233", R.mipmap.flag_gh, "GHS"),
            new Country("GI", "Gibraltar", "+350", R.mipmap.flag_gi, "GIP"),
            new Country("GL", "Greenland", "+299", R.mipmap.flag_gl, "DKK"),
            new Country("GM", "Gambia", "+220", R.mipmap.flag_gm, "GMD"),
            new Country("GN", "Guinea", "+224", R.mipmap.flag_gn, "GNF"),
            new Country("GP", "Guadeloupe", "+590", R.mipmap.flag_gp, "EUR"),
            new Country("GQ", "Equatorial Guinea", "+240", R.mipmap.flag_gq, "XAF"),
            new Country("GR", "Greece", "+30", R.mipmap.flag_gr, "EUR"),
            new Country("GS", "South Georgia and the South Sandwich Islands", "+500", R.mipmap.flag_gs,
                    "GBP"),
            new Country("GT", "Guatemala", "+502", R.mipmap.flag_gt, "GTQ"),
            new Country("GU", "Guam", "+1", R.mipmap.flag_gu, "USD"),
            new Country("GW", "Guinea-Bissau", "+245", R.mipmap.flag_gw, "XOF"),
            new Country("GY", "Guyana", "+595", R.mipmap.flag_gy, "GYD"),
            new Country("HK", "Hong Kong", "+852", R.mipmap.flag_hk, "HKD"),
            new Country("HM", "Heard Island and McDonald Islands", "+000", R.mipmap.flag_hm, "AUD"),
            new Country("HN", "Honduras", "+504", R.mipmap.flag_hn, "HNL"),
            new Country("HR", "Croatia", "+385", R.mipmap.flag_hr, "HRK"),
            new Country("HT", "Haiti", "+509", R.mipmap.flag_ht, "HTG"),
            new Country("HU", "Hungary", "+36", R.mipmap.flag_hu, "HUF"),
            new Country("ID", "Indonesia", "+62", R.mipmap.flag_id, "IDR"),
            new Country("IE", "Ireland", "+353", R.mipmap.flag_ie, "EUR"),
            new Country("IL", "Israel", "+972", R.mipmap.flag_il, "ILS"),
            new Country("IM", "Isle of Man", "+44", R.mipmap.flag_im, "GBP"),
            new Country("IN", "India", "+91", R.mipmap.flag_in, "INR"),
            new Country("IO", "British Indian Ocean Territory", "+246", R.mipmap.flag_io, "USD"),
            new Country("IQ", "Iraq", "+964", R.mipmap.flag_iq, "IQD"),
            new Country("IR", "Iran, Islamic Republic of", "+98", R.mipmap.flag_ir, "IRR"),
            new Country("IS", "Iceland", "+354", R.mipmap.flag_is, "ISK"),
            new Country("IT", "Italy", "+39", R.mipmap.flag_it, "EUR"),
            new Country("JE", "Jersey", "+44", R.mipmap.flag_je, "JEP"),
            new Country("JM", "Jamaica", "+1", R.mipmap.flag_jm, "JMD"),
            new Country("JO", "Jordan", "+962", R.mipmap.flag_jo, "JOD"),
            new Country("JP", "Japan", "+81", R.mipmap.flag_jp, "JPY"),
            new Country("KE", "Kenya", "+254", R.mipmap.flag_ke, "KES"),
            new Country("KG", "Kyrgyzstan", "+996", R.mipmap.flag_kg, "KGS"),
            new Country("KH", "Cambodia", "+855", R.mipmap.flag_kh, "KHR"),
            new Country("KI", "Kiribati", "+686", R.mipmap.flag_ki, "AUD"),
            new Country("KM", "Comoros", "+269", R.mipmap.flag_km, "KMF"),
            new Country("KN", "Saint Kitts and Nevis", "+1", R.mipmap.flag_kn, "XCD"),
            new Country("KP", "North Korea", "+850", R.mipmap.flag_kp, "KPW"),
            new Country("KR", "South Korea", "+82", R.mipmap.flag_kr, "KRW"),
            new Country("KW", "Kuwait", "+965", R.mipmap.flag_kw, "KWD"),
            new Country("KY", "Cayman Islands", "+345", R.mipmap.flag_ky, "KYD"),
            new Country("KZ", "Kazakhstan", "+7", R.mipmap.flag_kz, "KZT"),
            new Country("LA", "Lao People's Democratic Republic", "+856", R.mipmap.flag_la, "LAK"),
            new Country("LB", "Lebanon", "+961", R.mipmap.flag_lb, "LBP"),
            new Country("LC", "Saint Lucia", "+1", R.mipmap.flag_lc, "XCD"),
            new Country("LI", "Liechtenstein", "+423", R.mipmap.flag_li, "CHF"),
            new Country("LK", "Sri Lanka", "+94", R.mipmap.flag_lk, "LKR"),
            new Country("LR", "Liberia", "+231", R.mipmap.flag_lr, "LRD"),
            new Country("LS", "Lesotho", "+266", R.mipmap.flag_ls, "LSL"),
            new Country("LT", "Lithuania", "+370", R.mipmap.flag_lt, "LTL"),
            new Country("LU", "Luxembourg", "+352", R.mipmap.flag_lu, "EUR"),
            new Country("LV", "Latvia", "+371", R.mipmap.flag_lv, "LVL"),
            new Country("LY", "Libyan Arab Jamahiriya", "+218", R.mipmap.flag_ly, "LYD"),
            new Country("MA", "Morocco", "+212", R.mipmap.flag_ma, "MAD"),
            new Country("MC", "Monaco", "+377", R.mipmap.flag_mc, "EUR"),
            new Country("MD", "Moldova, Republic of", "+373", R.mipmap.flag_md, "MDL"),
            new Country("ME", "Montenegro", "+382", R.mipmap.flag_me, "EUR"),
            new Country("MF", "Saint Martin", "+590", R.mipmap.flag_mf, "EUR"),
            new Country("MG", "Madagascar", "+261", R.mipmap.flag_mg, "MGA"),
            new Country("MH", "Marshall Islands", "+692", R.mipmap.flag_mh, "USD"),
            new Country("MK", "Macedonia, The Former Yugoslav Republic of", "+389", R.mipmap.flag_mk,
                    "MKD"),
            new Country("ML", "Mali", "+223", R.mipmap.flag_ml, "XOF"),
            new Country("MM", "Myanmar", "+95", R.mipmap.flag_mm, "MMK"),
            new Country("MN", "Mongolia", "+976", R.mipmap.flag_mn, "MNT"),
            new Country("MO", "Macao", "+853", R.mipmap.flag_mo, "MOP"),
            new Country("MP", "Northern Mariana Islands", "+1", R.mipmap.flag_mp, "USD"),
            new Country("MQ", "Martinique", "+596", R.mipmap.flag_mq, "EUR"),
            new Country("MR", "Mauritania", "+222", R.mipmap.flag_mr, "MRO"),
            new Country("MS", "Montserrat", "+1", R.mipmap.flag_ms, "XCD"),
            new Country("MT", "Malta", "+356", R.mipmap.flag_mt, "EUR"),
            new Country("MU", "Mauritius", "+230", R.mipmap.flag_mu, "MUR"),
            new Country("MV", "Maldives", "+960", R.mipmap.flag_mv, "MVR"),
            new Country("MW", "Malawi", "+265", R.mipmap.flag_mw, "MWK"),
            new Country("MX", "Mexico", "+52", R.mipmap.flag_mx, "MXN"),
            new Country("MY", "Malaysia", "+60", R.mipmap.flag_my, "MYR"),
            new Country("MZ", "Mozambique", "+258", R.mipmap.flag_mz, "MZN"),
            new Country("NA", "Namibia", "+264", R.mipmap.flag_na, "NAD"),
            new Country("NC", "New Caledonia", "+687", R.mipmap.flag_nc, "XPF"),
            new Country("NE", "Niger", "+227", R.mipmap.flag_ne, "XOF"),
            new Country("NF", "Norfolk Island", "+672", R.mipmap.flag_nf, "AUD"),
            new Country("NG", "Nigeria", "+234", R.mipmap.flag_ng, "NGN"),
            new Country("NI", "Nicaragua", "+505", R.mipmap.flag_ni, "NIO"),
            new Country("NL", "Netherlands", "+31", R.mipmap.flag_nl, "EUR"),
            new Country("NO", "Norway", "+47", R.mipmap.flag_no, "NOK"),
            new Country("NP", "Nepal", "+977", R.mipmap.flag_np, "NPR"),
            new Country("NR", "Nauru", "+674", R.mipmap.flag_nr, "AUD"),
            new Country("NU", "Niue", "+683", R.mipmap.flag_nu, "NZD"),
            new Country("NZ", "New Zealand", "+64", R.mipmap.flag_nz, "NZD"),
            new Country("OM", "Oman", "+968", R.mipmap.flag_om, "OMR"),
            new Country("PA", "Panama", "+507", R.mipmap.flag_pa, "PAB"),
            new Country("PE", "Peru", "+51", R.mipmap.flag_pe, "PEN"),
            new Country("PF", "French Polynesia", "+689", R.mipmap.flag_pf, "XPF"),
            new Country("PG", "Papua New Guinea", "+675", R.mipmap.flag_pg, "PGK"),
            new Country("PH", "Philippines", "+63", R.mipmap.flag_ph, "PHP"),
            new Country("PK", "Pakistan", "+92", R.mipmap.flag_pk, "PKR"),
            new Country("PL", "Poland", "+48", R.mipmap.flag_pl, "PLN"),
            new Country("PM", "Saint Pierre and Miquelon", "+508", R.mipmap.flag_pm, "EUR"),
            new Country("PN", "Pitcairn", "+872", R.mipmap.flag_pn, "NZD"),
            new Country("PR", "Puerto Rico", "+1", R.mipmap.flag_pr, "USD"),
            new Country("PS", "Palestinian Territory, Occupied", "+970", R.mipmap.flag_ps, "ILS"),
            new Country("PT", "Portugal", "+351", R.mipmap.flag_pt, "EUR"),
            new Country("PW", "Palau", "+680", R.mipmap.flag_pw, "USD"),
            new Country("PY", "Paraguay", "+595", R.mipmap.flag_py, "PYG"),
            new Country("QA", "Qatar", "+974", R.mipmap.flag_qa, "QAR"),
            new Country("RE", "Reunion", "+262", R.mipmap.flag_re, "EUR"),
            new Country("RO", "Romania", "+40", R.mipmap.flag_ro, "RON"),
            new Country("RS", "Serbia", "+381", R.mipmap.flag_rs, "RSD"),
            new Country("RU", "Russia", "+7", R.mipmap.flag_ru, "RUB"),
            new Country("RW", "Rwanda", "+250", R.mipmap.flag_rw, "RWF"),
            new Country("SA", "Saudi Arabia", "+966", R.mipmap.flag_sa, "SAR"),
            new Country("SB", "Solomon Islands", "+677", R.mipmap.flag_sb, "SBD"),
            new Country("SC", "Seychelles", "+248", R.mipmap.flag_sc, "SCR"),
            new Country("SD", "Sudan", "+249", R.mipmap.flag_sd, "SDG"),
            new Country("SE", "Sweden", "+46", R.mipmap.flag_se, "SEK"),
            new Country("SG", "Singapore", "+65", R.mipmap.flag_sg, "SGD"),
            new Country("SH", "Saint Helena, Ascension and Tristan Da Cunha", "+290", R.mipmap.flag_sh,
                    "SHP"),
            new Country("SI", "Slovenia", "+386", R.mipmap.flag_si, "EUR"),
            new Country("SJ", "Svalbard and Jan Mayen", "+47", R.mipmap.flag_sj, "NOK"),
            new Country("SK", "Slovakia", "+421", R.mipmap.flag_sk, "EUR"),
            new Country("SL", "Sierra Leone", "+232", R.mipmap.flag_sl, "SLL"),
            new Country("SM", "San Marino", "+378", R.mipmap.flag_sm, "EUR"),
            new Country("SN", "Senegal", "+221", R.mipmap.flag_sn, "XOF"),
            new Country("SO", "Somalia", "+252", R.mipmap.flag_so, "SOS"),
            new Country("SR", "Suriname", "+597", R.mipmap.flag_sr, "SRD"),
            new Country("SS", "South Sudan", "+211", R.mipmap.flag_ss, "SSP"),
            new Country("ST", "Sao Tome and Principe", "+239", R.mipmap.flag_st, "STD"),
            new Country("SV", "El Salvador", "+503", R.mipmap.flag_sv, "SVC"),
            new Country("SX", "Sint Maarten", "+1", R.mipmap.flag_sx, "ANG"),
            new Country("SY", "Syrian Arab Republic", "+963", R.mipmap.flag_sy, "SYP"),
            new Country("SZ", "Swaziland", "+268", R.mipmap.flag_sz, "SZL"),
            new Country("TC", "Turks and Caicos Islands", "+1", R.mipmap.flag_tc, "USD"),
            new Country("TD", "Chad", "+235", R.mipmap.flag_td, "XAF"),
            new Country("TF", "French Southern Territories", "+262", R.mipmap.flag_tf, "EUR"),
            new Country("TG", "Togo", "+228", R.mipmap.flag_tg, "XOF"),
            new Country("TH", "Thailand", "+66", R.mipmap.flag_th, "THB"),
            new Country("TJ", "Tajikistan", "+992", R.mipmap.flag_tj, "TJS"),
            new Country("TK", "Tokelau", "+690", R.mipmap.flag_tk, "NZD"),
            new Country("TL", "East Timor", "+670", R.mipmap.flag_tl, "USD"),
            new Country("TM", "Turkmenistan", "+993", R.mipmap.flag_tm, "TMT"),
            new Country("TN", "Tunisia", "+216", R.mipmap.flag_tn, "TND"),
            new Country("TO", "Tonga", "+676", R.mipmap.flag_to, "TOP"),
            new Country("TR", "Turkey", "+90", R.mipmap.flag_tr, "TRY"),
            new Country("TT", "Trinidad and Tobago", "+1", R.mipmap.flag_tt, "TTD"),
            new Country("TV", "Tuvalu", "+688", R.mipmap.flag_tv, "AUD"),
            new Country("TW", "Taiwan", "+886", R.mipmap.flag_tw, "TWD"),
            new Country("TZ", "Tanzania, United Republic of", "+255", R.mipmap.flag_tz, "TZS"),
            new Country("UA", "Ukraine", "+380", R.mipmap.flag_ua, "UAH"),
            new Country("UG", "Uganda", "+256", R.mipmap.flag_ug, "UGX"),
            new Country("UM", "U.S. Minor Outlying Islands", "+1", R.mipmap.flag_um, "USD"),
            new Country("US", "United States", "+1", R.mipmap.flag_us, "USD"),
            new Country("UY", "Uruguay", "+598", R.mipmap.flag_uy, "UYU"),
            new Country("UZ", "Uzbekistan", "+998", R.mipmap.flag_uz, "UZS"),
            new Country("VA", "Holy See (Vatican City State)", "+379", R.mipmap.flag_va, "EUR"),
            new Country("VC", "Saint Vincent and the Grenadines", "+1", R.mipmap.flag_vc, "XCD"),
            new Country("VE", "Venezuela, Bolivarian Republic of", "+58", R.mipmap.flag_ve, "VEF"),
            new Country("VG", "Virgin Islands, British", "+1", R.mipmap.flag_vg, "USD"),
            new Country("VI", "Virgin Islands, U.S.", "+1", R.mipmap.flag_vi, "USD"),
            new Country("VN", "Vietnam", "+84", R.mipmap.flag_vn, "VND"),
            new Country("VU", "Vanuatu", "+678", R.mipmap.flag_vu, "VUV"),
            new Country("WF", "Wallis and Futuna", "+681", R.mipmap.flag_wf, "XPF"),
            new Country("WS", "Samoa", "+685", R.mipmap.flag_ws, "WST"),
            new Country("XK", "Kosovo", "+383", R.mipmap.flag_xk, "EUR"),
            new Country("YE", "Yemen", "+967", R.mipmap.flag_ye, "YER"),
            new Country("YT", "Mayotte", "+262", R.mipmap.flag_yt, "EUR"),
            new Country("ZA", "South Africa", "+27", R.mipmap.flag_za, "ZAR"),
            new Country("ZM", "Zambia", "+260", R.mipmap.flag_zm, "ZMW"),
            new Country("ZW", "Zimbabwe", "+263", R.mipmap.flag_zw, "USD"),
    };
    // endregion
/*
    // region Variables
    public static final int SORT_BY_NONE = 0;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_ISO = 2;
    public static final int SORT_BY_DIAL_CODE = 3;
    public static final int THEME_OLD = 1;
    public static final int THEME_NEW = 2;
    private int theme;

    private int style;
    private Context context;
    private int sortBy = SORT_BY_NONE;
    private OnCountryPickerListener onCountryPickerListener;
    private boolean canSearch = true;

    private List<Country> countries;
    private EditText searchEditText;
    private RecyclerView countriesRecyclerView;
    private LinearLayout rootView;
    private int textColor;
    private int hintColor;
    private int backgroundColor;
    private int searchIconId;
    private Drawable searchIcon;
    private CountriesAdapter adapter;
    private List<Country> searchResults;
    private BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;
    // endregion

    // endregion

    // region Listeners
    private void sortCountries(@NonNull List<Country> countries) {
        if (sortBy == SORT_BY_NAME) {
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country country1, Country country2) {
                    return country1.getName().trim().compareToIgnoreCase(country2.getName().trim());
                }
            });
        } else if (sortBy == SORT_BY_ISO) {
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country country1, Country country2) {
                    return country1.getCode().trim().compareToIgnoreCase(country2.getCode().trim());
                }
            });
        } else if (sortBy == SORT_BY_DIAL_CODE) {
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country country1, Country country2) {
                    return country1.getDialCode().trim().compareToIgnoreCase(country2.getDialCode().trim());
                }
            });
        }
    }
    // endregion





    private void search(String searchQuery) {
        searchResults.clear();
        for (Country country : countries) {
            if (country.getName().toLowerCase(Locale.ENGLISH).contains(searchQuery.toLowerCase())) {
                searchResults.add(country);
            }
        }
        sortCountries(searchResults);
    }


    private void initiateUi(View sheetView) {
        searchEditText = sheetView.findViewById(R.id.country_code_picker_search);
        countriesRecyclerView = sheetView.findViewById(R.id.countries_recycler_view);
        rootView = sheetView.findViewById(R.id.rootView);
    }
    // endregion

    public void setCountries(@NonNull List<Country> countries) {
        this.countries.clear();
        this.countries.addAll(countries);
        sortCountries(this.countries);
    }

    public Country getCountryFromSIM() {
        TelephonyManager telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null
                && telephonyManager.getSimState() != TelephonyManager.SIM_STATE_ABSENT) {
            return getCountryByISO(telephonyManager.getSimCountryIso());
        }
        return null;
    }

    public Country getCountryByLocale(@NonNull Locale locale) {
        String countryIsoCode = locale.getISO3Country().substring(0, 2).toLowerCase();
        return getCountryByISO(countryIsoCode);
    }

    public Country getCountryByName(@NonNull String countryName) {
        Collections.sort(countries, new NameComparator());
        Country country = new Country();
        country.setName(countryName);
        int i = Collections.binarySearch(countries, country, new NameComparator());
        if (i < 0) {
            return null;
        } else {
            return countries.get(i);
        }
    }

    public Country getCountryByISO(@NonNull String countryIsoCode) {
        Collections.sort(countries, new ISOCodeComparator());
        Country country = new Country();
        country.setCode(countryIsoCode);
        int i = Collections.binarySearch(countries, country, new ISOCodeComparator());
        if (i < 0) {
            return null;
        } else {
            return countries.get(i);
        }
    }
    // endregion

    // region Builder
    public static class Builder {
        private Context context;
        private int sortBy = SORT_BY_NONE;
        private boolean canSearch = true;
        private OnCountryPickerListener onCountryPickerListener;
        private int style;
        private int theme = THEME_NEW;

        public Builder with(@NonNull Context context) {
            this.context = context;
            return this;
        }

        public Builder style(@NonNull @StyleRes int style) {
            this.style = style;
            return this;
        }

        public Builder sortBy(@NonNull int sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        public Builder listener(@NonNull OnCountryPickerListener onCountryPickerListener) {
            this.onCountryPickerListener = onCountryPickerListener;
            return this;
        }

        public Builder canSearch(@NonNull boolean canSearch) {
            this.canSearch = canSearch;
            return this;
        }

        public Builder theme(@NonNull int theme) {
            this.theme = theme;
            return this;
        }

        public CountryPicker build() {
            return new CountryPicker(this);
        }
    }
    // endregion

    // region Comparators
    public static class ISOCodeComparator implements Comparator<Country> {
        @Override
        public int compare(Country country, Country nextCountry) {
            return country.getCode().compareToIgnoreCase(nextCountry.getCode());
        }
    }

    public static class NameComparator implements Comparator<Country> {
        @Override
        public int compare(Country country, Country nextCountry) {
            return country.getName().compareToIgnoreCase(nextCountry.getName());
        }
    }*/
    // endregion
}
