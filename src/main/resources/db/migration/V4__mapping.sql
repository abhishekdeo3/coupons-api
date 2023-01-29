DROP TABLE IF EXISTS members_coupons_mapping CASCADE;

CREATE TABLE IF NOT EXISTS members_coupons_mapping
(

    member_id BIGINT NOT NULL,
    coupon_id BIGINT NOT NULL,

    CONSTRAINT members_coupons_mapping__pkey PRIMARY KEY (member_id, coupon_id),
    CONSTRAINT member_members_coupons_mapping__id__fkey FOREIGN KEY (member_id) REFERENCES member (id),
    CONSTRAINT coupon_members_coupons_mapping__id__fkey FOREIGN KEY (coupon_id) REFERENCES coupon (id)
);

CREATE INDEX IF NOT EXISTS members_coupons_mapping__idx on members_coupons_mapping (member_id);
CREATE INDEX IF NOT EXISTS members_coupons_mapping__id__idx on members_coupons_mapping (coupon_id);