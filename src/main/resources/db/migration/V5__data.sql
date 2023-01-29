INSERT INTO payback.member(id, member_id, last_name, first_name)
VALUES (1000, 1, 'John', 'Decker'),
       (1001, 2, 'Patric', 'Christian'),
       (1002, 3, 'Peter', 'Thomas'),
       (1003, 4, 'Sebastian', 'James'),
       (1004, 5, 'Michael', 'Son');

INSERT INTO payback.coupon(id, coupon_id, valid_from, valid_until, latitude, longitude, city)
VALUES (10000, 100, '2023-01-01', '2023-03-31', 52.150002, 10.333333, 'Salzgitter'), -- Salzgitter, Lower Saxony
       (10001, 101, '2023-01-01', '2023-02-28', 52.520008, 13.404954, 'Berlin'),     -- Berlin
       (10002, 102, '2023-02-01', '2023-06-30', 50.883331, 8.016667, 'Siegen'),      -- Siegen, North Rhine-Westphalia
       (10003, 103, '2023-01-01', '2023-03-31', 49.583332, 11.016667, 'Erlangen'),   -- Erlangen, Bavaria
       (10004, 104, '2023-01-01', '2023-03-31', 51.183334, 7.200000, 'Remscheid'),   -- Remscheid, North Rhine-Westphalia
       (10005, 105, '2023-01-01', '2023-03-31', 51.099998, 7.116667, 'Bergisch'),                                                                 -- Bergisch Gladbach, North Rhine-Westphalia
       (10006, 106, '2023-01-01', '2023-03-31', 48.137154, 11.576124, 'Munich'); -- Munich, Bayern


INSERT INTO payback.members_coupons_mapping(member_id, coupon_id)
VALUES (1000, 10000),
       (1000, 10001),
       (1000, 10002),
       (1000, 10006);