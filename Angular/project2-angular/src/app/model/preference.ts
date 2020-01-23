export class Preference {
    min_price: number;
    max_price: number;
    num_beds: number;
    num_baths: number;
    city: string;
    state_code: string;

    public constructor(init?: Partial<Preference>) {
        Object.assign(this, init);
    }
}
