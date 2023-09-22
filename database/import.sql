INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Harju');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Saare ');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Hiiu');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Lääne');


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
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Liina', 'Härm', 'liina.harm@hiiumaa.ee', '+3725187580', 'Orjaku küla, Hiiumaa', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Valdo ', 'Kivi', 'valdo.kivi@ieg.ee', '+3725652887', 'Holmi 14, Haapsalu', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Andrus', 'Saat', 'andrus.saat@saarteliinid.ee', '+3725294467', 'Roomasaare tee 12, Kuressaare', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Marek', 'Rauk', 'marek.rauk@blrt.ee', '+37256888825', 'Peetri tn T5, Tallinn', true);
INSERT INTO public.contact (id, first_name, last_name, email, telephone, address, is_captain) VALUES (DEFAULT, 'Kesse', 'Kuningriik', 'indrek@pluss.ee', '+3725130809', 'Kesse küla, Muhu vald', true);


INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'captain');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Kuusalu vald, Hara küla, Hara sadam, 74810', 59.588142, 25.612600);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Muhu vald, Kuivastu küla, Kuivastu sadam, 94702', 58.573661, 23.396522);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 4, 'Lootsi 6, Pärnu', 58.386415, 24.489315);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Peetri, Tallinn', 59.452399, 24.728840);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Triigi küla, Saaremaa', 58.594201, 22.718295);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 3, 'Hiiu maakond, Hiiumaa vald, Orjaku küla, Orjaku sadam, 92114', 58.788683, 22.770871);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 5, 'Lääne maakond, Haapsalu linn, Haapsalu linn, Holmi tn 14, 90502', 58.958086, 23.527435);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'www.saarteliinid.ee', 58.217611, 22.504654);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Harju maakond, Tallinn, Põhja-Tallinna linnaosa, Peetri tänav T5, 10415', 59.454638, 24.730113);
INSERT INTO public.location (id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Saare maakond, Muhu vald, Kesse küla, Jaani-Aadu, 94720', 58.632258, 23.443211);


INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 1, 1, 'Hara', 'www.harasadam.ee', '2023-05-01', '2023-09-30', 3.00, 4.00, 15, '+37256900433', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 2, 2, 'Kuivastu', 'www.saarteliinid.ee', '2023-01-01', '2023-12-31', 2.10, 5.00, 50, '+37253428555', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 3, 5, 'Pärnu Jahisadam', 'https://jahtklubi.ee/jahtklubi', '2023-04-01', '2023-11-30', 7.40, 45.00, 85, '56781234', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 6, 8, 'Orjaku', 'sadamad.hiiumaa.ee', '2023-05-01', '2023-09-30', 2.90, 70.00, 30, '+37253455059', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 7, 9, 'Haapsalu', 'www.veskiviigi.ee', '2023-05-15', '2023-09-15', 2.50, 20.00, 74, '+3725652887', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 8, 10, 'Roomassaare', 'www.saarteliinid.ee', '2023-01-01', '2023-12-31', 80.00, 5.40, 54, '+3724530140', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 9, 11, 'Noblessner', 'www.noblessner.ee', '2023-05-01', '2023-10-31', 4.50, 50.00, 126, '+3726102205', 'A');
INSERT INTO public.harbour (id, location_id, contact_id, name, homepage, navigation_start, navigation_end, min_depth, min_width, spots, phone_number, status) VALUES (DEFAULT, 10, 12, 'Kesse-Jaani', 'www.kessekuningriik.ee', '2023-05-01', '2023-11-01', 1.30, 10.00, 12, '+3725130809', 'A');


INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 3, 3, 'jaan', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 1, 2, 'tarvi', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 2, 2, 'janis', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 4, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 6, 1, 'KadriKalliskivi', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 5, 2, 'SilverÜkssilm', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 7, 3, 'KarabasBarabas', '123', 'D');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 8, 2, 'LiinaHärm', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 9, 2, 'ValdoKivi', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 10, 2, 'AndrusSaat', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 11, 2, 'MarekRauk', '123', 'A');
INSERT INTO public."user" (id, contact_id, role_id, username, password, status) VALUES (DEFAULT, 12, 2, 'KesseKuningriik', '123', 'A');


INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 1, 'Uus', 7.00, 2.00, 1.70, 'A', 'Estonia');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 1, 'Tuule', 9.60, 2.10, 1.60, 'A', 'EE');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 2, 'Laine', 8.40, 1.80, 1.40, 'A', 'SE');
INSERT INTO public.vessel (id, user_id, name, length, width, draft, status, country) VALUES (DEFAULT, 3, 'Kraken', 12.00, 2.50, 1.90, 'A', 'FI');

INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 1, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 1, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 1, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 2, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 2, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 2, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 2, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 5, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 6, 3, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 7, 3, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 8, 3, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 9, 3, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 5, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 6, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 7, 4, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 8, 4, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 9, 4, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 5, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 5, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 5, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 5, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 6, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 7, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 8, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 9, 5, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 5, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 6, 6, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 7, 6, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 8, 6, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 9, 6, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 1, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 2, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 3, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 4, 7, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 5, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 6, 7, false);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 7, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 8, 7, true);
INSERT INTO public.harbour_extra (id, extra_id, harbour_id, is_available) VALUES (DEFAULT, 9, 7, true);