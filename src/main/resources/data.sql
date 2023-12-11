INSERT INTO public.weather (date, city, state, lat, lon) VALUES ('2023-03-20', 'Jasper', 'Alabama', 33.8423, -87.2771);
INSERT INTO public.weather (date, city, state, lat, lon) VALUES ('2023-02-18', 'Belmont', 'California', 37.5180, -122.2916);
INSERT INTO public.weather (date, city, state, lat, lon) VALUES ('2023-01-01', 'Carson City', 'Nevada', 39.1644, -119.7669);
INSERT INTO public.weather (date, city, state, lat, lon) VALUES ('2023-02-18', 'Madison', 'New Jersey', 40.7580, -74.4178);
INSERT INTO public.weather (date, city, state, lat, lon) VALUES ('2023-01-01', 'Madison', 'New Jersey', 40.7580, -74.4178);

-- Jasper
INSERT INTO public.temperatures (temperature, weather_id) VALUES (12.9, 1);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (16.7, 1);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (10.0, 1);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (2.3, 1);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (22.9, 1);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (-5.6, 1);

-- Belmont
INSERT INTO public.temperatures (temperature, weather_id) VALUES (14.7, 2);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (19.2, 2);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (5.3, 2);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (18.1, 2);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (0.0, 2);

-- Carson City
INSERT INTO public.temperatures (temperature, weather_id) VALUES (19.1, 3);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (15.7, 3);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (6.9, 3);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (14.2, 3);

-- Madison 2023-02-18
INSERT INTO public.temperatures (temperature, weather_id) VALUES (10.1, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (12.5, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (15.7, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (21.6, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (19.3, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (15.8, 4);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (9.2, 4);

-- Madison 2023-01-01
INSERT INTO public.temperatures (temperature, weather_id) VALUES (9.5, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (10.2, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (14.3, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (17.5, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (19.1, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (23.6, 5);
INSERT INTO public.temperatures (temperature, weather_id) VALUES (18.7, 5);