INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Harju');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Saare ');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Hiiu');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Pärnu');

INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'duss');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'WC');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'vesi');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'elekter');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'saun');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'slip');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'mänguväljak');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'ratastooliga ligipääsetav WC');
INSERT INTO public.extra (id, name) VALUES (DEFAULT, 'ratastooliga ligipääsetav duss');


INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Tarvi', 'Velström', 'tarvi.velström@mail.ee', '+3725021000', 'Kuusalu vald, Hara küla', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Janis', 'Osa', 'janis.osa@saarteliinid.ee', '+37253026741', null, true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Jaan', 'Suur', 'jaan@mail.ee', '+37256584612', 'Teine koht 15, Tallinn', false);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Admin', 'Uus', 'admin@mail.ee', '+37256584214', null, false);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Silver', 'Ükssilm', 'ykssilm@sadam.ee', '55891234', 'Kullakangi 6, Haapsalu linn', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Kadri', 'Kalliskivi', 'kalliskivi@sadam.ee', '56901234', 'Smaragdi 12, Pärnu', false);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Karabas', 'Barabas', 'barabas@sadam.ee', '51901234', 'Tsirkuse 2', false);


INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'captain');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Kuusalu vald, Hara küla, Hara sadam, 74810', 59.588142, 25.612600);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Muhu vald, Kuivastu küla, Kuivastu sadam, 94702', 58.573661, 23.396522);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 4, 'Lootsi 6, Pärnu', 58.386415, 24.489315);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Peetri, Tallinn', 59.452399, 24.728840);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Triigi küla, Saaremaa', 58.594201, 22.718295);

INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 1, 1, 'Hara', 'www.harasadam.ee', '2023-05-01', '2023-09-30', 3.00, 4.00, 15, '+37256900433', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 2, 2, 'Kuivastu', 'www.saarteliinid.ee', '2023-01-01', '2023-12-31', 2.10, 5.00, 50, '+37253428555', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 3, 5, 'Pärnu Jahisadam', 'https://jahtklubi.ee/jahtklubi', '2023-04-01', '2023-11-30', 7.40, 45.00, 85, '56781234', 'A');

INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 3, 3, 'jaan', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 1, 2, 'tarvi', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 2, 2, 'janis', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 4, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 6, 1, 'KadriKalliskivi', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 5, 2, 'SilverÜkssilm', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 7, 3, 'KarabasBarabas', '123', 'D');

INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 1, 'Uus', 7.00, 2.00, 1.70, 'A', 'Estonia');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 1, 'Tuule', 9.60, 2.10, 1.60, 'A', 'EE');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 2, 'Laine', 8.40, 1.80, 1.40, 'A', 'SE');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 3, 'Kraken', 12.00, 2.50, 1.90, 'A', 'FI');

INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 3, 1);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 4, 1);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 3, 2);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id) VALUES (DEFAULT, 4, 2);
