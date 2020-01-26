export class Property {
    type: string;
    street_num: number;
    street: string;
    city: string;
    zip: number;
    apt_num: number;
    num_beds: number;
    num_baths: number;
    photo: string;
    price: number;
    revemp_owned: boolean;
    sq_ft: number;
    state: string;
    email: string;

    public constructor(init?: Partial<Property>) {
        Object.assign(this, init);
    }

}
