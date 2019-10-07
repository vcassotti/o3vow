import { shallowMount } from "@vue/test-utils";
import Message from "@/components/Message.vue";

describe("HelloWorld.vue", () => {
  it("renders props.msg when passed", () => {
    const msg = "new message";
    const wrapper = shallowMount(Message, {
      propsData: { msg }
    });
    expect(wrapper.text()).toMatch(msg);
  });
});
